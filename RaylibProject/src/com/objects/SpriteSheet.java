/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 28-2nd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 28-2nd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: SpriteSheet.java                                           */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

package com.objects;

import com.raylib.Texture;
import com.raylib.Color;
import com.raylib.Vector2;

import static com.raylib.Raylib.loadTexture;
import static com.raylib.Raylib.drawTextureEx;
import static com.raylib.Raylib.drawTexturePro;
import static com.raylib.Raylib.drawRectangle;
import static com.raylib.Raylib.WHITE;
import com.raylib.Rectangle;

public class SpriteSheet
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

	Texture spriteSheet;		// Texture of the sprite sheet
	Vector2 position;			// Position for the square of the sprite sheet
    float scale;				// Scale of the sprite sheet
    float rotation;				// Rotation of the sprite sheet
    Color color = new Color();	// Color of the sprite sheet

	int frameCount;				// Number of frames in the sprite sheet
	int currentFrame;			// Current frame of the sprite sheet
	Vector2 frameSize;			// Width and height of the frame in the sprite sheet
	Vector2 ColisionBox;		// Colision box of the sprite sheet

	int skipFPS;				// Number of frames to skip in the sprite sheet
	int skipFPSCount;			// Number of frames to skip in the sprite sheet

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

	public SpriteSheet(String path, int frameCount, Vector2 frameSize, int skipFPS)
	{
		try
		{
			spriteSheet = loadTexture(path);
		}
		catch (Exception e)
		{
			System.out.println("Error loading texture: " + e.getMessage());
		}

		position = new Vector2(frameSize.getX() / 2, frameSize.getY() / 2);
		ColisionBox = new Vector2(frameSize.getX(), frameSize.getY());
		scale = 1;
		rotation = 0;
		color = WHITE;
		this.frameCount = frameCount;
		currentFrame = 0;
		this.skipFPS = skipFPS;
		skipFPSCount = 0;
		this.frameSize = frameSize;
	}

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void updateSprite(boolean resetFrame, boolean invertXAxis)
	{
		Rectangle source = new Rectangle(currentFrame * frameSize.getX(), 0, frameSize.getX(), frameSize.getY());
		Rectangle dest = new Rectangle(position.getX(), position.getY() , frameSize.getX() * scale, frameSize.getY() * scale);
		Vector2 origin = new Vector2(frameSize.getX() * scale / 2, frameSize.getY() * scale / 2);

		// NOTE: param source is for the zone of the sprite sheet to draw
		// NOTE: param dest is for the position and size of the sprite sheet to draw
		// NOTE: param origin is for the center of the sprite sheet to draw

		// invert x axis
		if (invertXAxis)
		{
			invertXAxis(source);
		}
		
		drawTexturePro(spriteSheet, source, dest, origin, rotation, color);

		if (skipFPSCount < skipFPS)
		{
			skipFPSCount++;
		}
		else
		{
			currentFrame++;
			skipFPSCount = 0;
		}

		if (currentFrame >= frameCount || resetFrame)
		{
			currentFrame = 0;
		}
	}

	public void drawColisionBox()
	{
		drawRectangle(
			(int)(position.getX() - (frameSize.getX() * scale / 2)), 
			(int)(position.getY() - (frameSize.getY() * scale / 2)), 
			(int)(frameSize.getX() * scale), 
			(int)(frameSize.getY() * scale), 
			color
		);
	}

	public void invertXAxis(Rectangle source)
	{
		source.setWidth(-frameSize.getX());
	}

/***********************************************************************************/
/***                                 GETTERS                                       */
/***********************************************************************************/

    public Texture getTexture()
	{
		return spriteSheet;
	}

    public Vector2 getPosition()
	{
		return position;
	}

    public float getScale()
	{
		return scale;
	}
    
    public float getRotation()
	{
		return rotation;
	}

    public Color getColor()
	{
		return color;
	}

	public int getFrameCount()
	{
		return frameCount;
	}

	public int getSkipFPS()
	{
		return skipFPS;
	}

	public int getSkipFPSCount()
	{
		return skipFPSCount;
	}

	public Vector2 getFrameSize()
	{
		return frameSize;
	}

/***********************************************************************************/
/***                                 SETTERS                                       */	
/***********************************************************************************/

    public void setPosition(int x, int y)
	{
		position.setX(x);
		position.setY(y);
	}
    
    public void setScale(float scale)
	{
		this.scale = scale;
	}

    public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}

    public void setColor(Color color)
	{
		this.color = color;
	}

	public void setFrameCount(int frameCount)
	{
		this.frameCount = frameCount;
	}

	public void setSkipFPS(int skipFPS)
	{
		this.skipFPS = skipFPS;
	}

	public void setSkipFPSCount(int skipFPSCount)
	{
		this.skipFPSCount = skipFPSCount;
	}

	public void setFrameSize(Vector2 frameSize)
	{
		this.frameSize = frameSize;
	}
}
