import Planes.*;
import models.MilitaryType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public List<CargoPlane> getCargoPlanes() {
        @SuppressWarnings("unchecked") List<CargoPlane> listOfCargoPlanes = (List<CargoPlane>) planes.
                stream().filter(plane -> plane instanceof CargoPlane).collect(Collectors.toList());
        return listOfCargoPlanes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        @SuppressWarnings("unchecked") List<PassengerPlane> listOfPassengerPlanes = (List<PassengerPlane>) planes.
                stream().filter(plane -> plane instanceof PassengerPlane).collect(Collectors.toList());
        return listOfPassengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        @SuppressWarnings("unchecked") List<MilitaryPlane> listOfMilitaryPlanes = (List<MilitaryPlane>) planes.
                stream().filter(plane -> plane instanceof MilitaryPlane).collect(Collectors.toList());
        return listOfMilitaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(getPassengerPlanes(),
                (o1, o2) -> o1.getPassengersCapacity() - o2.getPassengersCapacity());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == MilitaryType.BOMBER)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        @SuppressWarnings("unchecked") List<ExperimentalPlane> listOfExperimentalPlanes = (List<ExperimentalPlane>) planes.
                stream().filter(plane -> plane instanceof ExperimentalPlane).collect(Collectors.toList());
        return listOfExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getPlaneMaxFlightDistance() - o2.getPlaneMaxFlightDistance());
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getPlaneMaxSpeed() - o2.getPlaneMaxSpeed());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getPlaneMaxLoadCapacity() - o2.getPlaneMaxLoadCapacity());
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(List<? extends Plane> planesList) {
        planesList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
