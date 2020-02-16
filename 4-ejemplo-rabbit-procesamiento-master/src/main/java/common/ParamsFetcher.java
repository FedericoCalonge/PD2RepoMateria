package common;

public class ParamsFetcher {

    private static int QUEUE_PARAM_POSITION = 0;
    private static int AMOUNT_PARAM_POSITION = 1;

    public static String getQueueName(String[] args) {
        if (args.length <= QUEUE_PARAM_POSITION) {
            throw new IllegalArgumentException("Falta el nombre de cola en los parámetros");
        }
        return args[QUEUE_PARAM_POSITION];
    }

    public static int getAmountOfMessages(String[] args) {
        if (args.length < AMOUNT_PARAM_POSITION) {
            //por defecto, es 1
            return 1;
        }
        return Integer.parseInt(args[AMOUNT_PARAM_POSITION]);
    }


}
