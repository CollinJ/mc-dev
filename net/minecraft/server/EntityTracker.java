package net.minecraft.server;

import java.util.*;

public class EntityTracker {

    private Set a;
    private MCHashTable b;
    private MinecraftServer c;
    private int d;

    public EntityTracker(MinecraftServer minecraftserver) {
        a = ((Set) (new HashSet()));
        b = new MCHashTable();
        c = minecraftserver;
        d = minecraftserver.f.a();
    }

    public void a(Entity entity) {
        if (entity instanceof EntityPlayerMP) {
            a(entity, 512, 2);
            EntityPlayerMP entityplayermp = (EntityPlayerMP) entity;
            Iterator iterator = a.iterator();

            do {
                if (!iterator.hasNext()) {
                    break;
                }
                EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) iterator.next();

                if (entitytrackerentry.a != entityplayermp) {
                    entitytrackerentry.a(entityplayermp);
                }
            } while (true);
        } else if (entity instanceof EntityItem) {
            a(entity, 64, 20);
        } else if (entity instanceof EntityMinecart) {
            a(entity, 160, 4);
        } else if (entity instanceof IAnimals) {
            a(entity, 160, 2);
        }
    }

    public void a(Entity entity, int i, int j) {
        if (i > d) {
            i = d;
        }
        if (b.b(entity.c)) {
            throw new IllegalStateException("Entity is already tracked!");
        } else {
            EntityTrackerEntry entitytrackerentry = new EntityTrackerEntry(entity, i, j);

            a.add(((entitytrackerentry)));
            b.a(entity.c, ((entitytrackerentry)));
            entitytrackerentry.b(c.e.k);
            return;
        }
    }

    public void b(Entity entity) {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) b.d(entity.c);

        if (entitytrackerentry != null) {
            a.remove(((entitytrackerentry)));
            entitytrackerentry.a();
        }
    }

    public void a() {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = a.iterator();

        do {
            if (!iterator.hasNext()) {
                break;
            }
            EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) iterator.next();

            entitytrackerentry.a(c.e.k);
            if (entitytrackerentry.j && (entitytrackerentry.a instanceof EntityPlayerMP)) {
                ((List) (arraylist)).add((((EntityPlayerMP) entitytrackerentry.a)));
            }
        } while (true);
        label0:
        for (int i = 0; i < ((List) (arraylist)).size(); i++) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) ((List) (arraylist)).get(i);
            Iterator iterator1 = a.iterator();

            do {
                if (!iterator1.hasNext()) {
                    continue label0;
                }
                EntityTrackerEntry entitytrackerentry1 = (EntityTrackerEntry) iterator1.next();

                if (entitytrackerentry1.a != entityplayermp) {
                    entitytrackerentry1.a(entityplayermp);
                }
            } while (true);
        }
    }

    public void a(Entity entity, Packet packet) {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) b.a(entity.c);

        if (entitytrackerentry != null) {
            entitytrackerentry.a(packet);
        }
    }
}