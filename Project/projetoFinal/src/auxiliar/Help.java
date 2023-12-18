package auxiliar;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public  class Help {

    public Date retornaData(){
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        return d;
    }

   Scanner scan = new Scanner(System.in);

    public  String leString(){
        return scan.nextLine();
    }

    public  int leInteiro(){
        String aux;
        int i=0;
        aux = leString();
        try {
            i = Integer.parseInt(aux);
        }
        catch (Exception e) {
            throw new RuntimeException("ERRO: CODIGO INVALIDO!");
        }
        return i;
    }





}
