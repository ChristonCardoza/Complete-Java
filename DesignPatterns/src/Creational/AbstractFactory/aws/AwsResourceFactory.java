package Creational.AbstractFactory.aws;

import Creational.AbstractFactory.Instance;
import Creational.AbstractFactory.ResourceFactory;
import Creational.AbstractFactory.Storage;
//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
