package net.minecraft.server;

public class MovingObjectPosition {

    public EnumMovingObjectType a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Vec3D f;
    public Entity g;

    public MovingObjectPosition(int i, int j, int k, int l, Vec3D vec3d) {
        a = EnumMovingObjectType.a;
        b = i;
        c = j;
        d = k;
        e = l;
        f = Vec3D.b(vec3d.a, vec3d.b, vec3d.c);
    }

    public MovingObjectPosition(Entity entity) {
        a = EnumMovingObjectType.b;
        g = entity;
        f = Vec3D.b(entity.p, entity.q, entity.r);
    }
}
