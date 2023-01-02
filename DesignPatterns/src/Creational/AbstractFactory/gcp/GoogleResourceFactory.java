package Creational.AbstractFactory.gcp;

import Creational.AbstractFactory.Instance;
import Creational.AbstractFactory.ResourceFactory;
import Creational.AbstractFactory.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
