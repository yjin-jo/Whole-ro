package model.dao;

public class DAOFactory {
    private DAOFactory(){}
    
    private static class DAOFactoryHandelr{
        private static final DAOFactory INSTANCE = new DAOFactory();
    }
    
    
    public static DAOFactory getInstance(){
        return DAOFactoryHandelr.INSTANCE;
    }
}
