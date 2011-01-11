package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

public class Vec3D {

    private static List d = new ArrayList();
    private static int e = 0;
    public double a;
    public double b;
    public double c;

    public static Vec3D a(double d1, double d2, double d3) {
        return new Vec3D(d1, d2, d3);
    }

    public static void a() {
        e = 0;
    }

    public static Vec3D b(double d1, double d2, double d3) {
        if (e >= d.size()) {
            d.add(((a(0.0D, 0.0D, 0.0D))));
        }
        return ((Vec3D) d.get(e++)).e(d1, d2, d3);
    }

    private Vec3D(double d1, double d2, double d3) {
        if (d1 == -0D) {
            d1 = 0.0D;
        }
        if (d2 == -0D) {
            d2 = 0.0D;
        }
        if (d3 == -0D) {
            d3 = 0.0D;
        }
        a = d1;
        b = d2;
        c = d3;
    }

    private Vec3D e(double d1, double d2, double d3) {
        a = d1;
        b = d2;
        c = d3;
        return this;
    }

    public Vec3D b() {
        double d1 = MathHelper.a(a * a + b * b + c * c);

        if (d1 < 0.0001D) {
            return b(0.0D, 0.0D, 0.0D);
        } else {
            return b(a / d1, b / d1, c / d1);
        }
    }

    public Vec3D c(double d1, double d2, double d3) {
        return b(a + d1, b + d2, c + d3);
    }

    public double a(Vec3D vec3d) {
        double d1 = vec3d.a - a;
        double d2 = vec3d.b - b;
        double d3 = vec3d.c - c;

        return (double) MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);
    }

    public double b(Vec3D vec3d) {
        double d1 = vec3d.a - a;
        double d2 = vec3d.b - b;
        double d3 = vec3d.c - c;

        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public double d(double d1, double d2, double d3) {
        double d4 = d1 - a;
        double d5 = d2 - b;
        double d6 = d3 - c;

        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double c() {
        return (double) MathHelper.a(a * a + b * b + c * c);
    }

    public Vec3D a(Vec3D vec3d, double d1) {
        double d2 = vec3d.a - a;
        double d3 = vec3d.b - b;
        double d4 = vec3d.c - c;

        if (d2 * d2 < 1.0000000116860974E-007D) {
            return null;
        }
        double d5 = (d1 - a) / d2;

        if (d5 < 0.0D || d5 > 1.0D) {
            return null;
        } else {
            return b(a + d2 * d5, b + d3 * d5, c + d4 * d5);
        }
    }

    public Vec3D b(Vec3D vec3d, double d1) {
        double d2 = vec3d.a - a;
        double d3 = vec3d.b - b;
        double d4 = vec3d.c - c;

        if (d3 * d3 < 1.0000000116860974E-007D) {
            return null;
        }
        double d5 = (d1 - b) / d3;

        if (d5 < 0.0D || d5 > 1.0D) {
            return null;
        } else {
            return b(a + d2 * d5, b + d3 * d5, c + d4 * d5);
        }
    }

    public Vec3D c(Vec3D vec3d, double d1) {
        double d2 = vec3d.a - a;
        double d3 = vec3d.b - b;
        double d4 = vec3d.c - c;

        if (d4 * d4 < 1.0000000116860974E-007D) {
            return null;
        }
        double d5 = (d1 - c) / d4;

        if (d5 < 0.0D || d5 > 1.0D) {
            return null;
        } else {
            return b(a + d2 * d5, b + d3 * d5, c + d4 * d5);
        }
    }

    public String toString() {
        return (new StringBuilder()).append("(").append(a).append(", ").append(b).append(", ").append(c).append(")").toString();
    }
}
