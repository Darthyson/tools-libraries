package org.selfbus.sbtools.prodedit.binding;

import com.jgoodies.binding.value.BindingConverter;

/**
 * A converter that converts an integer value to a string value.
 */
public class IntegerValueConverter implements BindingConverter<Integer, String>
{
//   private static final Logger LOGGER = LoggerFactory.getLogger(IntegerValueConverter.class);

   private final int radix;
   
   /**
    * Create an integer value converter for decimal values.
    */
   public IntegerValueConverter()
   {
      this(10);
   }

   /**
    * Create an integer value converter.
    * 
    * @param radix - the radix of the values.
    */
   public IntegerValueConverter(int radix)
   {
      this.radix = radix;
   }
   
   /**
    * {@inheritDoc}
    */
   @Override
   public String targetValue(Integer sourceValue)
   {
      if (sourceValue == null)
         return "";

      try
      {
         return Integer.toString((Integer) sourceValue, radix);
      }
      catch (Exception e)
      {
         return "";
      }
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Integer sourceValue(String targetValue)
   {
      if (targetValue == null || ((String) targetValue).isEmpty())
         return null;

      try
      {
         return Integer.parseInt((String) targetValue, radix);
      }
      catch (NumberFormatException e)
      {
         return null;
      }
   }
}
