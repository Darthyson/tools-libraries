package org.selfbus.sbtools.knxio.model.manufacturer.program.parameter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.selfbus.sbtools.knxio.model.Namespaces;
import org.selfbus.sbtools.knxio.model.manufacturer.program.memory.MemoryLocation;

/**
 * A parameter.
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Parameter extends AnonymousParameter
{
   private static final long serialVersionUID = 8552431629259326041L;

   @XmlElement(name = "Memory", namespace = Namespaces.KNX)
   private MemoryLocation memory;

   public MemoryLocation getMemory()
   {
      return memory;
   }

   public void setMemory(MemoryLocation memory)
   {
      this.memory = memory;
   }

   @Override
   public String toString()
   {
      return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
         .appendSuper(super.toString())
         .append("memory", memory)
         .toString();
   }
}
