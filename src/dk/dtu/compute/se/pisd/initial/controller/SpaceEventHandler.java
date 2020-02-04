/*
 *  This file is part of the initial project provided for the
 *  course "Project in Software Development (02362)" held at
 *  DTU Compute at the Technical University of Denmark.
 *
 *  Copyright (C) 2019, 2020: Ekkart Kindler, ekki@dtu.dk
 *
 *  This software is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; version 2 of the License.
 *
 *  This project is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this project; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package dk.dtu.compute.se.pisd.initial.controller;

import dk.dtu.compute.se.pisd.initial.model.Board;
import dk.dtu.compute.se.pisd.initial.model.Space;
import dk.dtu.compute.se.pisd.initial.view.SpaceView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * ...
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 *
 */
public class SpaceEventHandler implements EventHandler<ActionEvent> {

    public SpaceEventHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        Object source = event.getSource();
        if (source instanceof SpaceView) {
            SpaceView spaceView = (SpaceView) source;
            Space space = spaceView.space;
            if (space != null) {
                Board board = space.board;
                Space right = board.getSpace(space.x + 1, space.y);
                Space left = board.getSpace(space.x - 1, space.y);
                Space down = board.getSpace(space.x, space.y - 1);
                Space up = board.getSpace(space.x, space.y + 1);
                Space cykliskRight = board.getSpace(space.x + 7, space.y);
                Space cykliskLeft = board.getSpace(space.x - 7, space.y);
                Space cykliskDown = board.getSpace(space.x, space.y - 7);
                Space cykliskUp = board.getSpace(space.x, space.y + 7);

                if ((right != null && right.isActive()) || (left != null && left.isActive()) || ( down != null && down.isActive()) || (up != null && up.isActive()) ||
                (right != null && cykliskRight.isActive()) || (left != null && cykliskLeft.isActive()) || ( down != null && cykliskDown.isActive()) || (up != null && cykliskUp.isActive())) {
                    board.setActive(space);
                    event.consume();
                }

            }
        }
    }

}
