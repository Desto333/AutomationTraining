package planes;

import java.util.Objects;

public class CargoPlane extends Plane {

    private boolean isOversize;

    public CargoPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, boolean isOversize) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.isOversize = isOversize;
    }

    public boolean isOversize() {
        return isOversize;
    }

    public void setOversize(boolean oversize) {
        isOversize = oversize;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", isOversize=" + isOversize +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return isOversize == that.isOversize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOversize);
    }
}
