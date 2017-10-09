/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbfanotacionpolacainversa;

import java.util.*;

/**
 *
 * @author Johnguisao
 */
public class FBFANotacionPolacaInversa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String expresion = "(r$¬(s#(¬(t))))?q";
        String expresionResultante = "";
        Stack<String> pilaOperadores = new Stack<String>();
        for (int i = 0; i < expresion.length(); i++) {
            char cExpresion = expresion.charAt(i);
            boolean agregado = false;
            switch (cExpresion) {
                case '(':
                    pilaOperadores.add(String.valueOf(cExpresion));
                    break;
                case '¬'://Operador Negación.
                    while(!agregado){
                        if(peticionAgregarOperadorPila(pilaOperadores,cExpresion)){
                            pilaOperadores.push(String.valueOf(cExpresion));
                            agregado = true;
                        }
                        else {
                            expresionResultante += pilaOperadores.pop();
                        }
                    }
                    break;
                case '?'://Operador And
                    while(!agregado){
                        if(peticionAgregarOperadorPila(pilaOperadores,cExpresion)){
                            pilaOperadores.push(String.valueOf(cExpresion));
                            agregado = true;
                        }
                        else {
                            expresionResultante += pilaOperadores.pop();
                        }
                    }
                    break;
                case '$'://Operador Or
                    while(!agregado){
                        if(peticionAgregarOperadorPila(pilaOperadores,cExpresion)){
                            pilaOperadores.push(String.valueOf(cExpresion));
                            agregado = true;
                        }
                        else {
                            expresionResultante += pilaOperadores.pop();
                        }
                    }
                    break;
                case '%'://Operador condicional
                    while(!agregado){
                        if(peticionAgregarOperadorPila(pilaOperadores,cExpresion)){
                            pilaOperadores.push(String.valueOf(cExpresion));
                            agregado = true;
                        }
                        else {
                            expresionResultante += pilaOperadores.pop();
                        }
                    }
                    break;
                case '#'://Operador bicondicional
                    while(!agregado){
                        if(peticionAgregarOperadorPila(pilaOperadores,cExpresion)){
                            pilaOperadores.push(String.valueOf(cExpresion));
                            agregado = true;
                        }
                        else {
                            expresionResultante += pilaOperadores.pop();
                        }
                    }
                    break;
                case ')':
                    boolean cierreParentesis = false;
                    while(!cierreParentesis){
                        char operadorAIngresar = pilaOperadores.pop().charAt(0);
                        if(operadorAIngresar == '('){
                            cierreParentesis = true;
                        }
                        else {
                            expresionResultante += operadorAIngresar;
                        }
                    }
                    break;
                default://Cualquier letra representando una proposición.
                    expresionResultante += cExpresion;
                    break;
            }
        }
        while(!pilaOperadores.empty()) {
            expresionResultante += pilaOperadores.pop();
        }
        System.out.print(expresionResultante + "\n");

    }

    public static boolean peticionAgregarOperadorPila(Stack<String> pilaOperadores, char operadorAIngresar) {
        boolean permiso = false;
        if (pilaOperadores.empty()) {
            permiso = true;
        } else {
            char peekPila = pilaOperadores.peek().charAt(0);
            if (encontrarPrioridad(operadorAIngresar) > encontrarPrioridad(peekPila)) {
                permiso = true;
            }
        }
        return permiso;
    }

    public static int encontrarPrioridad(char operadorAux) {
        int prioridadOperadorAux = 0;
        switch (operadorAux) {
            case '¬'://Operador Negación.
                prioridadOperadorAux = 4;
                break;
            case '?'://Operador And
                prioridadOperadorAux = 3;
                break;
            case '$'://Operador Or
                prioridadOperadorAux = 3;
                break;
            case '%'://Operador condicional
                prioridadOperadorAux = 2;
                break;
            case '#'://Operador bicondicional
                prioridadOperadorAux = 1;
                break;
            default:
                prioridadOperadorAux = 0;
                break;
        }
        return prioridadOperadorAux;
    }

}
