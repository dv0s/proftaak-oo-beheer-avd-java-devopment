package nl.avd.javadev.proftaak;

public enum ShapeType {
    CONE,
    CUBE,
    CYLINDER,
    PRISM,
    PYRAMID,
    SPHERE;

    public String toString(){
        switch(this){
            case CONE :
                return "Cone";
            case CUBE :
                return "Cube";
            case CYLINDER :
                return "Cylinder";
            case PRISM :
                return "Prism";
            case PYRAMID :
                return "Pyramid";
            case SPHERE :
                return "Sphere";
        }
        return null;
    }
}
