package br.com.christiancms.model;

public class GerarMatriz {

    public char[][] gerarMatriz() {
        int count;
        GerarAlfabeto g = new GerarAlfabeto();
        char matrixTemp[] = g.gerarAlfabeto();
        char abc[] = new char[matrixTemp.length * 2];

        for (int k = 0; k < 96; k++) {
            abc[k] = matrixTemp[k];
            abc[k + 96] = matrixTemp[k];
        }

        //Matriz bidimensional, onde "i" é a linha e "j" é a coluna
        char[][] matriz = new char[96][96];

        for (int i = 0; i < 96; i++) {
            count = 0;

            for (int j = 0; j < 96; j++) {
                
                matriz[i][j] = abc[count + i];
                count++;
            }
        }
        return matriz;
    }
}
