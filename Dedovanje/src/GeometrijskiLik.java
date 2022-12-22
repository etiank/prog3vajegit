public interface GeometrijskiLik {
    //Geometrijski lik je 2D geometrijska oblika
    //ima obseg in ploščino

    //INTERFACE želimo specificirat obnašanje nekega razreda ne pa implementacija
    //vse metode v interface so public
    //interface nikoli nima konstruktorja

    //Dobro lahko definirajo kako lahko dva sistema interagirata (API)

    public abstract double ploscina();
    public abstract double obseg();

}
