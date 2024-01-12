package test;

public class TestArgumentosVariables {

    public static void main(String[] args) {
        TestArgumentosVariables.imprimirNumeros(1, 2, 3, 4, 5, 6);
        imprimirNumeros(7, 8, 9);
        imprimirNumeros(10, -12384);
        
        variosParametros("Juan", 8,9,10);
    }

    private static void imprimirNumeros(int... numeros) {
        //private porque se consume solo aca dentro
        //static para que lo pueda consumir main
        //void porque no devuelve nada

        /*Argumentos Variables, hace referencia a que puedo definir un metodo, sin saber exactamente a priori, 
        la cantidad de elementos que va a recibir de ese tipo.
        El metodo, internamente, trata ese argumento, como un array, que es lo que va a terminar siendo,
        y lo puedo verificar debugeando ... numeros - type: int[]
        el tema es que si utilaza la sintaxis para arrays: 
         private static void imprimirNumeros(int[?] numeros) {
        tendría que indicarle, a priori, la cantidad de elementos ('?')
        en cambio, con la sintaxis de los "..." no es necesario, e internamente lo que va a armar es una array
        Por eso, en el for, se usa el array.length
         */
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("elemento: " + numeros[i]);
        }
    }

    /*El metodo, pordria tener mas argumentos, pero si uno es variable, debe ir a lo ultimo*/
    public static void variosParametros(String nombre, int... numeros) {
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);
    }
}
