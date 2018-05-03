/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restagendaclientjava;

import Metodos.MetodosAgenda;
import Metodos.MetodosPersona;
import Metodos.MetodosValidarAgenda;
import Metodos.MetodosValidarPersona;
import Objeto.AgendaObject;
import Objeto.PersonaObj;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author janto
 */
public class RestAgendaClientJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar usuario creado (UnMarshall)");
            System.out.println("3. Validar Agenda");
            System.out.println("4. Validar Persona");
            System.out.println("5. Mostrar Agenda");
            System.out.println("6. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        AnnadirContacto();
                        break;

                    case 2:
                        BusquedaContacto();
//                         u.UnMarshall();
                        //           u.UnMarshallAgenda(file);
                        break;
                    case 3:
                        //¿Tratar la excepcion y seguir corriendo el programa?
                        ValidarAgenda();
                        break;
                    case 4:
                        ValidarPersona();

                        break;
                    case 5:
                        MostrarAgenda();
                        break;

                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    public static void AnnadirContacto() {

        MetodosPersona mp = new MetodosPersona();
        Scanner sc = new Scanner(System.in);
        PersonaObj p = new PersonaObj();
        boolean correoCorrecto = false;
        String name = "";
        String email = "";
        int telephone = 0;

        System.out.print("Ingrese su nombre: ");
        name = sc.nextLine();

        while (!correoCorrecto) {

            System.out.print("Ingrese su correo: ");
            email = sc.nextLine();
            if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                correoCorrecto = true;
            } else {
                System.out.println("Correo no correcto");
            }
        }
        System.out.print("Ingrese la numero de telefono: ");
        telephone = sc.nextInt();
        p.setName(name);
        p.setEmail(email);
        p.setTelephone(telephone);
        mp.postXml(p, PersonaObj.class);
    }

    public static void BusquedaContacto() {
        MetodosPersona mp1 = new MetodosPersona();
        Scanner sc1 = new Scanner(System.in);
        String name1 = "";
        System.out.print("Ingrese el nombre a buscar: ");
        name1 = sc1.nextLine();

        PersonaObj ag2 = mp1.getXml(PersonaObj.class, name1);
        if (ag2 != null) {
            System.out.println("Name:" + ag2.getName());
            System.out.println("Email:" + ag2.getEmail());
            System.out.println("Telephone:" + ag2.getTelephone());
        } else {
            System.out.println("El usuario: " + name1 + " " + "no se encuentra en la agenda");
        }

    }

    public static void ValidarAgenda() {
        MetodosValidarAgenda mv = new MetodosValidarAgenda();
        System.out.println(mv.putXml());

    }

    public static void ValidarPersona() {
        PersonaObj p = new PersonaObj();
        MetodosValidarPersona mp = new MetodosValidarPersona();
        Scanner sc = new Scanner(System.in);
        boolean correoCorrecto = false;
        String name = "";
        String email = "";
        int telephone = 0;

        System.out.print("Ingrese su nombre: ");
        name = sc.nextLine();

        while (!correoCorrecto) {

            System.out.print("Ingrese su correo: ");
            email = sc.nextLine();
            if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                correoCorrecto = true;
            } else {
                System.out.println("Correo no correcto");
            }
        }
        System.out.print("Ingrese la numero de telefono: ");
        telephone = sc.nextInt();
        p.setName(name);
        p.setEmail(email);
        p.setTelephone(telephone);
        System.out.println(mp.putXml(p));

    }

    public static void MostrarAgenda() {
        MetodosAgenda ma = new MetodosAgenda();
        System.out.println(ma.getXml(AgendaObject.class));

    }
}
    
