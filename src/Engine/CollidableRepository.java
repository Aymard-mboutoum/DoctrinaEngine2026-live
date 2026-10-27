package Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollidableRepository implements Iterable<StaticActor> {
    private static CollidableRepository instance;
    private ArrayList<StaticActor> registeredActors;
    
    private CollidableRepository() {
        registeredActors = new ArrayList<>();
    }

    public static CollidableRepository getInstance() {
        if (instance == null) {
            instance = new CollidableRepository();
        }
        return instance;
    }

    public void registerActor(StaticActor actor) {
        registeredActors.add(actor);
    }

    public void registerActors(List<StaticActor> actors) {
        registeredActors.addAll(actors);
    }

    public void unregisterActor(StaticActor actor) {
        registeredActors.remove(actor);
    }

    public void unregisterActors(List<StaticActor> actors) {
        registeredActors.removeAll(actors);
    }

    public int count() {
        return registeredActors.size();
    }

    @Override
    public Iterator<StaticActor> iterator() {
        return registeredActors.iterator();
    }
}
