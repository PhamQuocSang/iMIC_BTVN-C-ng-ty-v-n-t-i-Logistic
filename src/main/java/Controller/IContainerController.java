package Controller;

import Model.Container;

import java.util.ArrayList;

public interface IContainerController {
    public ArrayList<Container> addContainer(ArrayList<Container> listCon);

    public ArrayList<Container> displayContainer(ArrayList<Container> listCon);

    public ArrayList<Container> deleteContainer(ArrayList<Container> listCon);

    public  ArrayList<Container> editContainer(ArrayList<Container> listCon);

}
