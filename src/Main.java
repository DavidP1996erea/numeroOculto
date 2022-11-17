public class Main extends Thread {

    // Se crean las variables estáticas necesarias
    public static int numeroAdivinar;
    public static boolean acertado=false;


    /**
     * El méotodo run será llamado por cada uno de los hilos, mientras el booleano acertado sea falso
     * los hilos buscarán el número que generado anteriormente. En una variable se guarda el resultado
     * de los intentos, y en caso de que devuelva -1, será que hay un ganador y se mostrará el nombre
     * del hilo que ha ganado.
     */
    @Override
    public void run(){
        int numero;

        int res=0;

                while(!acertado){
                    numero = (int)(Math.random()*100);
                    res = propuestaNumero(numero);

                    System.out.println("El hilo " +this.getName() + " esta intentando") ;
                }

        if (res == -1) {

            System.out.println("El hilo " + this.getName() + " ha ganado");


        }
    }

    /**
     * Con este método se comprueba si el hilo ha dado con el número, en caso de que lo haya encontrado
     * el booleano acertado se pondrá a true y el bucle del método run parará
     * @param numero
     * @return
     */
    private synchronized int propuestaNumero(int numero) {

        int resultado=0;

        if(numero==numeroAdivinar){
            resultado =1;
            acertado=true;
        }
        if(acertado){

            resultado = -1;

        }

        return resultado;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Se inicializa el número
        numeroAdivinar = (int)( Math.random() *100);

        // Se crean 5 hilos, se los pone nombre y se inician
        for(int i=0; i<5;i++){

            Thread h1 = new Main();
            h1.setName("hilo"+i);
            h1.start();
        }
    }
}