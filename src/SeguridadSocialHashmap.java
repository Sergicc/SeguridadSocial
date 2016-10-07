import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by usu26 on 23/09/2016.
 */
public class SeguridadSocialHashmap {
    private Map<String,Persona> personaMapDni = new HashMap<>();
    private Map<String,Persona> personaMapSs = new HashMap<>();

    public void altaPersona(Persona persona){
        if(!personaMapDni.containsKey(persona.getDni()) &&
                !personaMapSs.containsKey(persona.getNumSS())){
        personaMapDni.put(persona.getDni(),persona);
        personaMapSs.put(persona.getNumSS(),persona);
        }
    }
    public void bajaPersona(String dni) {
        if (personaMapDni.containsKey(dni)) {

            Persona persona = personaMapDni.get(dni);

            personaMapDni.remove(dni);
            personaMapSs.remove(persona.getNumSS());
        }
    }

    public Persona obtenerPersonaPorDNI(String dni) {
            return personaMapDni.get(dni);

        }

    public Persona obtenerPersonaPorNumSS(String numSS) {
            return personaMapSs.get(numSS);

    }


    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){

        List<Persona> aux = new ArrayList<>();
        for (Persona persona : personaMapDni.values()) {
            if (persona.getSalario() >= min && persona.getSalario() <= max) {
                aux.add(persona);
            }
        }
        return aux;

/*
        return personaMapDni.values().stream().
                filter(persona -> persona.getSalario() >= min && persona.getSalario() <= max).
                collect(Collectors.toList());
*/
    }
    public List<Persona> obtenerPersonasMayoresQue(int edad){

        List<Persona> aux = new ArrayList<>();
        for(Persona persona : personaMapDni.values()){
            if(persona.getEdad()> edad){
                aux.add(persona);
            }
        }
        return aux;
    }
    public List<Persona> obtenerTodas() {

        List<Persona> aux = new ArrayList<>();

        for (Persona persona : personaMapDni.values()) {
            aux.add(persona);
        }
        return aux;
    }

}


//personaMapDni.keySet();
//personaMapDni.values();
//personaMapDni.remove(dni);


