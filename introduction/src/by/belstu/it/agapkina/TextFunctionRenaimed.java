package by.belstu.it.agapkina;

/**
 * Created by Diana Agapkina on 20.02.2019
 */

public class TextFunctionRenaimed {
    public TextFunctionRenaimed() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getValue() {
        getString();
        return "Hello from first project";
    }

    private void getString() {
        String str = "new string";
    }

    public boolean delStr() {
        for (int i = 0; i < 9; i++) {
            if (i > -1 && i < 10) System.out.println(i);
        }
        return true;
    }

    public void OnCreate() {
        for (int count = 0; count < 10; count++) {
            System.out.println("Counter " + count);
        }
    }
}
