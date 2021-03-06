package decorator.functional;

import java.util.function.UnaryOperator;

interface Sandwich {
    String prepare();
}

class PlainSandwich implements Sandwich {
    @Override
    public String prepare() {
        return "Sandwich";
    }
}

class SandwichExample {
    private static class SandwichDecorator implements UnaryOperator<String> {
        @Override
        public String apply(String s) {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new SandwichDecorator()
                        .andThen(s -> s + " with sausage")
                        .andThen(s -> s + " with cheese")
                        .apply(new PlainSandwich().prepare())
        );

        System.out.println(
                new SandwichDecorator()
                        .compose(s -> s + " with sausage")
                        .compose(s -> s + " with cheese")
                        .apply(new PlainSandwich().prepare())
        );
    }
}
