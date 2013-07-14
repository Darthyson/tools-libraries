package org.selfbus.sbtools.prodedit.binding;

import java.text.MessageFormat;

import com.jgoodies.binding.value.BindingConverter;

/**
 * A read-only converter that converts an integer value to a string containing the value.
 */
public class FormatValueConverter implements BindingConverter
{
//   private static final Logger LOGGER = LoggerFactory.getLogger(IntegerValueConverter.class);
   private final String format;

   /**
    * Create a read-only converter that converts an integer value to a string containing the value.
    * The placeholder "{0}" in the format is replaced with the actual value. If the value is null,
    * an empty string is returned.
    *
    * @param format - the format to use
    */
   public FormatValueConverter(String format)
   {
      this.format = format;
   }
   
   /**
    * {@inheritDoc}
    */
   @Override
   public Object targetValue(Object sourceValue)
   {
      if (sourceValue == null)
         sourceValue = "";

      return MessageFormat.format(format, sourceValue.toString());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Object sourceValue(Object targetValue)
   {
      throw new IllegalAccessError("this converter is read only");
   }
}
