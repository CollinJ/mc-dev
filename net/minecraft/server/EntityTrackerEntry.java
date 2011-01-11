package net.minecraft.server;

import java.util.*;

public class EntityTrackerEntry {

    public Entity a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    private double l;
    private double m;
    private double n;
    private boolean o;
    public boolean j;
    public Set k;

    public EntityTrackerEntry(Entity entity, int i1, int j1) {
        i = 0;
        o = false;
        j = false;
        k = ((Set) (new HashSet()));
        a = entity;
        b = i1;
        c = j1;
        d = MathHelper.b(entity.l * 32D);
        e = MathHelper.b(entity.m * 32D);
        f = MathHelper.b(entity.n * 32D);
        g = MathHelper.d((entity.r * 256F) / 360F);
        h = MathHelper.d((entity.s * 256F) / 360F);
    }

    public boolean equals(Object obj) {
        if (obj instanceof EntityTrackerEntry) {
            return ((EntityTrackerEntry) obj).a.c == a.c;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return a.c;
    }

    public void a(List list) {
        j = false;
        if (!o || a.d(l, m, n) > 16D) {
            b(list);
            l = a.l;
            m = a.m;
            n = a.n;
            o = true;
            j = true;
        }
        if (i++ % c == 0) {
            int i1 = MathHelper.b(a.l * 32D);
            int j1 = MathHelper.b(a.m * 32D);
            int k1 = MathHelper.b(a.n * 32D);
            int l1 = MathHelper.d((a.r * 256F) / 360F);
            int i2 = MathHelper.d((a.s * 256F) / 360F);
            boolean flag = i1 != d || j1 != e || k1 != f;
            boolean flag1 = l1 != g || i2 != h;
            int j2 = i1 - d;
            int k2 = j1 - e;
            int l2 = k1 - f;
            Object obj = null;

            if (j2 < -128 || j2 >= 128 || k2 < -128 || k2 >= 128 || l2 < -128 || l2 >= 128) {
                obj = ((new Packet34EntityTeleport(a.c, i1, j1, k1, (byte) l1, (byte) i2)));
            } else if (flag && flag1) {
                obj = ((new Packet33RelEntityMoveLook(a.c, (byte) j2, (byte) k2, (byte) l2, (byte) l1, (byte) i2)));
            } else if (flag) {
                obj = ((new Packet31RelEntityMove(a.c, (byte) j2, (byte) k2, (byte) l2)));
            } else if (flag1) {
                obj = ((new Packet32EntityLook(a.c, (byte) l1, (byte) i2)));
            } else {
                obj = ((new Packet30Entity(a.c)));
            }
            if (obj != null) {
                a(((Packet) (obj)));
            }
            d = i1;
            e = j1;
            f = k1;
            g = l1;
            h = i2;
        }
    }

    public void a(Packet packet) {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = k.iterator(); iterator.hasNext(); entityplayermp.a.b(packet)) {
            entityplayermp = (EntityPlayerMP) iterator.next();
        }
    }

    public void a() {
        a(((Packet) (new Packet29DestroyEntity(a.c))));
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (entityplayermp == a) {
            return;
        }
        double d1 = entityplayermp.l - (double) (d / 32);
        double d2 = entityplayermp.n - (double) (f / 32);

        if (d1 >= (double) (-b) && d1 <= (double) b && d2 >= (double) (-b) && d2 <= (double) b) {
            if (!k.contains(((entityplayermp)))) {
                k.add(((entityplayermp)));
                entityplayermp.a.b(b());
            }
        } else if (k.contains(((entityplayermp)))) {
            k.remove(((entityplayermp)));
            entityplayermp.a.b(((Packet) (new Packet29DestroyEntity(a.c))));
        }
    }

    public void b(List list) {
        for (int i1 = 0; i1 < list.size(); i1++) {
            a((EntityPlayerMP) list.get(i1));
        }
    }

    private Packet b() {
        if (a instanceof EntityItem) {
            EntityItem entityitem = (EntityItem) a;
            Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);

            entityitem.l = (double) packet21pickupspawn.b / 32D;
            entityitem.m = (double) packet21pickupspawn.c / 32D;
            entityitem.n = (double) packet21pickupspawn.d / 32D;
            entityitem.o = (double) packet21pickupspawn.e / 128D;
            entityitem.p = (double) packet21pickupspawn.f / 128D;
            entityitem.q = (double) packet21pickupspawn.g / 128D;
            return ((Packet) (packet21pickupspawn));
        }
        if (a instanceof EntityPlayerMP) {
            return ((Packet) (new Packet20NamedEntitySpawn((EntityPlayer) a)));
        }
        if (a instanceof EntityMinecart) {
            EntityMinecart entityminecart = (EntityMinecart) a;

            if (entityminecart.ae == 0) {
                return ((Packet) (new Packet23VehicleSpawn(a, 10)));
            }
            if (entityminecart.ae == 1) {
                return ((Packet) (new Packet23VehicleSpawn(a, 11)));
            }
            if (entityminecart.ae == 2) {
                return ((Packet) (new Packet23VehicleSpawn(a, 12)));
            }
        }
        if (a instanceof EntityBoat) {
            return ((Packet) (new Packet23VehicleSpawn(a, 1)));
        }
        if (a instanceof IAnimals) {
            return ((Packet) (new Packet24MobSpawn((EntityLiving) a)));
        } else {
            throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(((((a)).getClass()))).append("!").toString());
        }
    }
}
