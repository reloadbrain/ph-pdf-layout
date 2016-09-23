/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.pdflayout.base;

import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.string.ToStringGenerator;
import com.helger.pdflayout.spec.EVertAlignment;

/**
 * Base class for objects having a horizontal and a vertical alignment.<br>
 * The alignment is always applied to the contained objects but not this object!
 *
 * @author Philip Helger
 * @param <IMPLTYPE>
 *        The implementation type of this class.
 */
public abstract class AbstractPLAlignedElement <IMPLTYPE extends AbstractPLAlignedElement <IMPLTYPE>>
                                               extends AbstractPLHorzAlignedElement <IMPLTYPE>
                                               implements IPLHasVerticalAlignment <IMPLTYPE>
{
  private EVertAlignment m_eVertAlign = DEFAULT_VERT_ALIGNMENT;

  public AbstractPLAlignedElement ()
  {}

  @Nonnull
  @OverridingMethodsMustInvokeSuper
  public IMPLTYPE setBasicDataFrom (@Nonnull final AbstractPLAlignedElement <?> aSource)
  {
    super.setBasicDataFrom (aSource);
    setVertAlign (aSource.m_eVertAlign);
    return thisAsT ();
  }

  @Nonnull
  public EVertAlignment getVertAlign ()
  {
    return m_eVertAlign;
  }

  @Nonnull
  public IMPLTYPE setVertAlign (@Nonnull final EVertAlignment eVertAlign)
  {
    m_eVertAlign = ValueEnforcer.notNull (eVertAlign, "VertAlign");
    return thisAsT ();
  }

  @Override
  public String toString ()
  {
    return ToStringGenerator.getDerived (super.toString ()).append ("VertAlign", m_eVertAlign).toString ();
  }
}
