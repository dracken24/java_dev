/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 28-2nd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 28-2nd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: init.java                                                  */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

package com.game;

import static com.raylib.Raylib.initWindow;
import static com.raylib.Raylib.setTargetFPS;

import static com.raylib.Raylib.beginDrawing;
import static com.raylib.Raylib.clearBackground;
import static com.raylib.Raylib.endDrawing;
import static com.raylib.Raylib.drawText;
import static com.raylib.Raylib.getMousePosition;
import static com.raylib.Raylib.VIOLET;
import static com.raylib.Raylib.LIGHTGRAY;

import com.raylib.Vector2;
import com.raylib.Rectangle;

import com.enums.PlayerType;
import com.player.Player;
import com.player.InitPlayer;

public class Core
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

	Player		player;
	Vector2		WindowSize;
	String		title;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

	public Core(Vector2 windowSize, String title)
	{
		WindowSize = windowSize;
		this.title = title;
		initWindow((int)WindowSize.getX(), (int)WindowSize.getY(), title);
        setTargetFPS(60);

		initPlayer();
	}

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void update()
	{
		beginDrawing();
			clearBackground(LIGHTGRAY);
			
			Vector2 mousePosition = getMousePosition();
            drawText("Mouse position: " + mousePosition.getX() + ", " + mousePosition.getY(), 10, 10, 20, VIOLET);
		
			player.update();

		endDrawing();
	}

	void initPlayer()
	{
		Vector2 playerPos = new Vector2(WindowSize.getX() / 2, WindowSize.getY() / 2);
		Vector2 playerSize = new Vector2(70, 70);
		int playerScale = 2;
		Rectangle playerColisionSize = new Rectangle(
			(WindowSize.getX() / 2) - (11 * playerScale),
			(WindowSize.getY() / 2) - ((playerSize.getY() - 50) * playerScale),
			22,
			55
		);

		player = new Player(playerPos, playerSize, playerColisionSize, playerScale);
		new InitPlayer(PlayerType.ICHIGO, player, playerPos, playerSize);
	}
}
