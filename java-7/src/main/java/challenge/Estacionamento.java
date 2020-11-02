package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private final List<Carro> carros = new ArrayList<>();

    private final int TAMANHO_ESTACIONAMENTO = 10;

    public void estacionar(Carro carro) {
        if(!isCheio()){
            carros.add(carro);
        }
        else if(!isTodosIdosos())
        {
            carros.remove(primeiroNaoIdoso());
            carros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros
                .stream()
                .anyMatch(carroList -> carroList.equals(carro));
    }

    private boolean isCheio(){
        return carros.size() == TAMANHO_ESTACIONAMENTO;
    }

    private boolean isTodosIdosos(){
        boolean resultado = !carros.isEmpty() && carros
                .stream()
                .allMatch(carro -> carro.getMotorista().getIdade() > 55);

        if (!resultado)
            return false;
        else
            throw new EstacionamentoException("Todos os motoristas são idosos");
    }

    private Carro primeiroNaoIdoso(){
        return carros
                .stream()
                .filter(carro -> carro.getMotorista().getIdade() <= 55)
                .findFirst()
                .get();
    }
}
