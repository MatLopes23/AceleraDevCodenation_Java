package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        return deslocar(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return deslocar(texto, -3);
    }

    private String deslocar(String texto, int deslocamento){
        if (texto == "") {
            throw new IllegalArgumentException();
        } else if (texto == null) {
            throw  new NullPointerException();
        }

        StringBuilder textoDeslocado = new StringBuilder();
        String textoLowerCase = texto.toLowerCase();

        int tamanhoTexto = textoLowerCase.length();

        for (int i = 0; i < tamanhoTexto; i++){
            char letra = textoLowerCase.charAt(i);

            if( letra >= 'a' && letra <= 'z'){
                int letraASCII = ((int) letra + deslocamento);

                textoDeslocado.append((char) letraASCII);
            }else{
                textoDeslocado.append(letra);
            }

        }

        return textoDeslocado.toString();
    }
}
