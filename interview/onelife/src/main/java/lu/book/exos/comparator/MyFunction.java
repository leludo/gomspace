package lu.book.exos.comparator;

/**
 * in the functional interface we have an abstract method ( public abstract is no necessary here because a method in a
 * public interface is public by default and without body this method is abstract
 * there is a single default method
 * static methods are possible too. there is no limitations on the number of methods you can find in an interface,
 * ==> only the default method must be alone
 * */

public interface MyFunction {

    int printIt(String sOne, String sTwo);

    default int printItUppercase(String sOne, String sTwo){
        System.out.println((sOne+sTwo).toUpperCase());
        return sOne.compareTo(sTwo);
    }

    static void iAmAStaticMethod(String s){ System.out.println(s);}

}
