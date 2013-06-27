package org.selfbus.sbtools.prodedit.utils;

import java.awt.Font;

import javax.swing.UIManager;

/**
 * Font utility methods.
 */
public final class FontUtils
{
   private static Font captionFont;

   /**
    * @return The default caption font for forms
    */
   public static Font getCaptionFont()
   {
      if (captionFont == null)
      {
         captionFont = UIManager.getDefaults().getFont("Label.font");
         captionFont = captionFont.deriveFont(Font.BOLD, captionFont.getSize() * 1.2f);
      }

      return captionFont;
   }

   // Disabled
   private FontUtils()
   {
   }
}
