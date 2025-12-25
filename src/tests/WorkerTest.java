//Classe de testes unitarios da classe Worker
package tests;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

class WorkerTest{
    Bank bank = new Bank("Bank 1","No Where",111111);

    Worker w1 = new Worker("Worker 1","worker1@gmail.com","+238 1111111","1000",ExperienceLevel.JUNIORLEVEL,bank);
    Worker w2 = new Worker("Worker 2","worker2@gmail.com","+238 2222222","2000",ExperienceLevel.MIDLEVEL,bank);
    Worker w3 = new Worker("Worker 3","worker3@gmail.com","+238 3333333","3000",ExperienceLevel.SENIORLEVEL,bank);
}
