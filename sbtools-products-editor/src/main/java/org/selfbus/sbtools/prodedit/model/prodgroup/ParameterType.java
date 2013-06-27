package org.selfbus.sbtools.prodedit.model.prodgroup;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.selfbus.sbtools.prodedit.model.enums.ParameterAtomicType;
import org.selfbus.sbtools.prodedit.model.interfaces.Identifiable;

import com.jgoodies.binding.beans.Model;

/**
 * The type of a program's parameter. The parameter type is used to group
 * parameters of the same type that can have the same range of values.
 *
 * The parameter type holds e.g. the possible values for a parameter and
 * minimum/maximum values for numbers.
 *
 * What one would expect here, which type a parameter is, contains the class
 * {@link ParameterAtomicType}, which can be access with
 * {@link #getAtomicType()}.
 */
@XmlType(propOrder = {})
@XmlAccessorType(XmlAccessType.NONE)
public class ParameterType extends Model implements Identifiable
{
   private static final long serialVersionUID = -6354471736343630279L;

   @XmlAttribute(name = "id", required = true)
   private int id;

   @XmlAttribute(name = "atomic_type", required = true)
   private ParameterAtomicType atomicType;

   @XmlAttribute(name = "name", required = true)
   private String name;

   @XmlAttribute(name = "min_value")
   private Integer minValue;

   @XmlAttribute(name = "max_value")
   private Integer maxValue;

   @XmlAttribute(name = "min_double_value")
   private Double minDoubleValue;

   @XmlAttribute(name = "max_double_value")
   private Double maxDoubleValue;

   @XmlAttribute(name = "low_access")
   private int lowAccess;

   @XmlAttribute(name = "high_access")
   private int highAccess;

   @XmlAttribute(name = "size")
   private int size;

   @XmlElementWrapper(name = "values")
   @XmlElement(name = "value")
   private Set<ParameterValue> values;

   /**
    * Create an empty parameter type.
    */
   public ParameterType()
   {
   }

   /**
    * Create a parameter type.
    *
    * @param atomicType - the parameter's atomic type.
    */
   public ParameterType(ParameterAtomicType atomicType)
   {
      this.atomicType = atomicType;
   }

   /**
    * Create a parameter type.
    *
    * @param atomicType - the parameter's atomic type.
    * @param name - the name
    */
   public ParameterType(ParameterAtomicType atomicType, String name)
   {
      this.atomicType = atomicType;
      this.name = name;
   }

   /**
    * @return the id
    */
   public int getId()
   {
      return id;
   }

   /**
    * @return the id as string
    */
   public String getIdStr()
   {
      return Integer.toString(id);
   }

   /**
    * Set the id.
    * 
    * @param id - the id to set.
    */
   public void setId(int id)
   {
      this.id = id;
   }

   /**
    * @return the atomic type of the parameter.
    */
   public ParameterAtomicType getAtomicType()
   {
      return atomicType;
   }

   /**
    * Set the atomic type of the parameter.
    * 
    * @param atomicType - the atomic type to set.
    */
   public void setAtomicType(ParameterAtomicType atomicType)
   {
      this.atomicType = atomicType;
   }

   /**
    * @return the name of the parameter type.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Set the name of the parameter type.
    * 
    * @param name - the name to set.
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * @return the minimum value.
    */
   public Integer getMinValue()
   {
      return minValue;
   }

   /**
    * Set the minimum value.
    * 
    * @param minValue - the minimum value to set.
    */
   public void setMinValue(Integer minValue)
   {
      this.minValue = minValue;
   }

   /**
    * @return the maximum value.
    */
   public Integer getMaxValue()
   {
      return maxValue;
   }

   /**
    * Set the maximum value.
    * 
    * @param maxValue - the maximum value to set.
    */
   public void setMaxValue(Integer maxValue)
   {
      this.maxValue = maxValue;
   }

   /**
    * @return the minimum double value.
    */
   public Double getMinDoubleValue()
   {
      return minDoubleValue;
   }

   /**
    * Set the minimum double value.
    * 
    * @param minValue - the minimum value to set.
    */
   public void setMinDoubleValue(Double minValue)
   {
      this.minDoubleValue = minValue;
   }

   /**
    * @return the maximum double value.
    */
   public Double getMaxDoubleValue()
   {
      return maxDoubleValue;
   }

   /**
    * Set the maximum double value.
    * 
    * @param maxValue - the maximum value to set.
    */
   public void setMaxDoubleValue(Double maxValue)
   {
      this.maxDoubleValue = maxValue;
   }

   /**
    * @return the allowed values or null if no specific allowed values are set.
    */
   public Set<ParameterValue> getValues()
   {
      return values;
   }

   /**
    * Add a parameter value to the parameter type's values
    * 
    * @param value - the value to add
    */
   public void addValue(ParameterValue value)
   {
      if (values == null)
         values = new HashSet<ParameterValue>();

      values.add(value);
   }

   /**
    * Set the allowed values or null if no specific allowed values are set.
    * 
    * @param values - the allowed values to set.
    */
   public void setValues(Set<ParameterValue> values)
   {
      this.values = values;
   }

   /**
    * @return the lowAccess
    */
   public int getLowAccess()
   {
      return lowAccess;
   }

   /**
    * @param lowAccess the lowAccess to set
    */
   public void setLowAccess(int lowAccess)
   {
      this.lowAccess = lowAccess;
   }

   /**
    * @return the highAccess
    */
   public int getHighAccess()
   {
      return highAccess;
   }

   /**
    * @param highAccess the highAccess to set
    */
   public void setHighAccess(int highAccess)
   {
      this.highAccess = highAccess;
   }

   /**
    * @return the size of the parameter in bits.
    */
   public int getSize()
   {
      return size;
   }

   /**
    * Set the size of the parameter in bits.
    *
    * @param size the size to set
    */
   public void setSize(int size)
   {
      this.size = size;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public int hashCode()
   {
      return id;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return name;
   }
}
