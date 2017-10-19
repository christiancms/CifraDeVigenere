package br.com.christiancms.model;

import java.text.Normalizer;

public class CifraVigenere {

    char[] mensagem;
    char[] palavraPasse;
    char[] resultado;
    char matriz[][];
    char[] texto;

    public CifraVigenere(String msg, String chave) {
        msg = Normalizar(msg);
        this.mensagem = msg.toCharArray();
        char[] chaveTemp = chave.toCharArray();
        this.palavraPasse = new char[msg.length()];
        int cont = 0;

        for (int i = 0; i < msg.length(); i++) {
            this.palavraPasse[i] = chaveTemp[cont];
            cont++;
            if (cont == chaveTemp.length) {
                cont = 0;
            }
        }

        GerarMatriz gm = new GerarMatriz();
        this.matriz = gm.gerarMatriz();
    }

    public static String Normalizar(String string) {
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        return string;
    }

    public String cifrar() {

        char[] cifrado = new char[mensagem.length];
        String retorna = "";
        int x, y;

        for (int cont = 0; cont < mensagem.length; cont++) {
            x = (int) this.mensagem[cont] - 32;
            y = (int) this.palavraPasse[cont] - 32;
            cifrado[cont] = this.matriz[x][y];
        }
        this.resultado = cifrado;

        for (int i = 0; i < cifrado.length; i++) {
            retorna += cifrado[i];
        }
        return retorna;
    }

    public String decifrar() {
        char[] decifrado = new char[mensagem.length];
        String retorno = "";
        int x = 0, y = 0;

        for (int cont = 0; cont < mensagem.length; cont++) {
            x = (int) this.mensagem[cont] - 32;
            y = (int) this.palavraPasse[cont] - 32;

            char[] coluna = new char[96];

            for (int i = 0; i < 96; i++) {
                coluna[i] = this.matriz[i][y];
            }
            int a = 0;
            boolean teste = false;
            do {
                if (coluna[a] == mensagem[cont]) {
                    break;
                }
                a++;
            } while (teste == false);

            decifrado[cont] = this.matriz[a][0];
        }

        for (int i = 0; i < decifrado.length; i++) {
            retorno += decifrado[i];
        }

        this.resultado = decifrado;
        return retorno;
    }
}
