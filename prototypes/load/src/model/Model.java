package model;

import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    private ArrayList<LineSegment> lines;
    private ArrayList<IGizmo> gizmos;
    private ArrayList<Absorber> absorbers;

    private Ball ball;
    private Wall walls;

    public Model() {

        gizmos = new ArrayList<>();
        absorbers = new ArrayList<>();
    }

    /*public void moveBall() {
        double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball
        CollisionDetails cd = timeUntilCollision();
        double tuc = cd.getTuc();
        if (tuc > moveTime) {
// No collision ...
            ball = movelBallForTime(ball, moveTime);
        } else {
// We've got a collision in tuc
            ball = movelBallForTime(ball, tuc);
// Post collision velocity ...
            ball.setVelo(cd.getVelo());
        }*/

    public void moveBall() {
        double moveTime = 0.05;

        if (!ball.isStopped() && ball != null) {

            CollisionDetails cd = timeUntilCollision();
        }
    }

    private CollisionDetails timeUntilCollision() {

        double time = 0;
        double minTime = 0;
        Vect ballVelocity = ball.getVelocity();
        Circle circle = ball.getCircle();
        Vect newVelocity = new Vect(0, 0);


        //for loop for each gizmo type


        return new CollisionDetails(minTime, newVelocity);

    }

    public void setBallVeloctiy(int x, int y) {
        ball.setVelocity(new Vect(x, y));
    }



    public void addCircle(Circle c) {
        gizmos.add(c);
    }

    public void addTriangle(Triangle t) {
        gizmos.add(t);
    }

    public void addSquare(Square s) {
        gizmos.add(s);
    }

    public void addLeftFlipper(LeftFlipper flipper) {
        gizmos.add(flipper);
    }

    public void addRightFlipper(RightFlipper flipper) {
        gizmos.add(flipper);
    }

    public void addAbsorber(Absorber a) {
        absorbers.add(a);
    }

    public void setBall(Ball b) {
        ball = b;
    }

    public Ball getBall() {
        return ball;
    }

    public ArrayList<IGizmo> getGizmos() {
        return gizmos;
    }

    public ArrayList<Absorber> getAbsorbers() {
        return absorbers;
    }

    public IGizmo findGizmo(String gizmoId) {
        for (IGizmo giz : getGizmos()) {
            if (giz.getId().equals(gizmoId))
                return giz;
        }
        return null;
    }

}