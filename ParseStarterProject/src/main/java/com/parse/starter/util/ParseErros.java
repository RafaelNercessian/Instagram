package com.parse.starter.util;

import java.util.HashMap;

/**
 * Created by Rafael on 07/03/2017.
 */

public class ParseErros {

    private HashMap<Integer,String> erros=new HashMap<>();

    public ParseErros() {
        erros.put(202,"Usuário já cadastrado");
        erros.put(201,"A senha não foi preenchida");
    }

    public String getErro(int codErro){
        return this.erros.get(codErro);
    }
}
