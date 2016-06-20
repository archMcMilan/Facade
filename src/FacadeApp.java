/**
 * Created by Artem on 20.06.16.
 */
public class FacadeApp {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.copy();
    }
}

//Facade
class Computer{
    Power power=new Power();
    DvdRom dvdRom=new DvdRom();
    Hdd hdd=new Hdd();
    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDvd(dvdRom);
    }
}

class Power{
    void on(){
        System.out.println("Switch on");
    }

    void off(){
        System.out.println("Switch off");
    }
}

class DvdRom{
    private  boolean data=false;

    public boolean hasData(){
        return data;
    }

    void load(){
        System.out.println("Disk has been booted");
        data=true;
    }

    void unload(){
        System.out.println("Disk has benn rebooted");
        data=false;
    }
}

class Hdd{
    void copyFromDvd(DvdRom dvdRom){
        if(dvdRom.hasData()){
            System.out.println("Data is copied from disk");
        }else{
            System.out.println("Boot disk with data");
        }
    }
}