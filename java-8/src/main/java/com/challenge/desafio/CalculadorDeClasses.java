package com.challenge.desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel{

    @Override
    public BigDecimal somar(Object classe){
        return soma(classe, possuiAnotation(classe, Somar.class));
    }

    @Override
    public BigDecimal subtrair(Object classe){
        return soma(classe, possuiAnotation(classe, Subtrair.class));
    }

    @Override
    public BigDecimal totalizar(Object classe){
        return somar(classe).subtract(subtrair(classe));
    }

    public List<String> possuiAnotation(Object classe, Class<? extends Annotation> annotation) {
        List<String> atributos = new ArrayList<>();

        for(Field field : classe.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(annotation) && field.getGenericType().equals(BigDecimal.class))
                atributos.add(field.getName());
        }

        return atributos;
    }

    public BigDecimal soma(Object classe, List<String> metodos){
        Method[] methods = classe.getClass().getMethods();

        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal resultado = BigDecimal.ZERO;

        for (String nomeMetodos : metodos){
            for(Method method : methods){
                if(method.getName().toUpperCase().contains("GET" + nomeMetodos.toUpperCase())){
                    try {
                        valor = (BigDecimal) method.invoke(classe);
                        if(valor != null)
                            resultado = resultado.add(valor);
                    }
                    catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return  resultado;
    }

}