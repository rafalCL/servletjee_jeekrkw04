package pl.coderslab.servletjee.servlet.utils;

public class OopExample {
    public static void main(String[] args) {
        ParentHiddenMethod childHM = new ChildHiddenMethod();
        childHM.hiddenMethod(); //nie ma polimorfizmu, metoda statyczna
        ChildHiddenMethod child = new ChildHiddenMethod();
        child.hiddenMethod(); //ukryliśmy metodę rodzica
    }
}
