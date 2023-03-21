
package com.foo.jetty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JpmsUtils {

    public static void printEnvironment(boolean showStandard) {
        String[] splits = null;
        List<String> list = new ArrayList<>();

        Runnable r = () -> {
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
            list.clear();
        };

        if (System.getProperty("jdk.module.path") != null) {
            splits = System.getProperty("jdk.module.path").split(":");
            System.out.println(System.getProperty("line.separator") + "MODULE PATH:" );
            for (String split : splits) {
                list.add(split);
            }
        }
        r.run();

        System.out.println(System.getProperty("line.separator") + "CLASS PATH:");
        splits = System.getProperty("java.class.path").split(":");
        for (String split : splits) {
            list.add(split);
        }
        r.run();

        System.out.println(System.getProperty("line.separator") + "BOOT LAYER:");
        if (showStandard) {
            ModuleLayer.boot().modules().stream().forEach(m -> {
                list.add(m.getName());
            });
        } else {
            ModuleLayer.boot().modules().stream().forEach(m -> {
                if (!m.getName().startsWith("java") && !m.getName().startsWith("jdk")) {
                    list.add(m.getName());
                }
            });
        }
        r.run();
        System.out.println("");
    }
}
