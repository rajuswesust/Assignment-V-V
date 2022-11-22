package online.shopping;

public interface InterfacePayment {

    public void setCharge(float charge);
    public float getCharge() ;

    public abstract float payment(float amount);

    public abstract float offers( float amount, float offer);

}
