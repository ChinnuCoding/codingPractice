package designPatterns.chainOfResponsibilities;


public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
