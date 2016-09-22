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
import com.helger.pdflayout.spec.EHorzAlignment;

/**
 * Base class for text and image elements - so elements only having a padding
 * but no border themselves.
 *
 * @author Philip Helger
 * @param <IMPLTYPE>
 *        The implementation type of this class.
 */
public abstract class AbstractPLHorzAlignedElement <IMPLTYPE extends AbstractPLHorzAlignedElement <IMPLTYPE>>
                                                   extends AbstractPLElement <IMPLTYPE>
                                                   implements IPLHasHorizontalAlignment <IMPLTYPE>
{
  private EHorzAlignment m_eHorzAlign = DEFAULT_HORZ_ALIGNMENT;

  public AbstractPLHorzAlignedElement ()
  {}

  @Nonnull
  @OverridingMethodsMustInvokeSuper
  public IMPLTYPE setBasicDataFrom (@Nonnull final AbstractPLHorzAlignedElement <?> aSource)
  {
    super.setBasicDataFrom (aSource);
    setHorzAlign (aSource.m_eHorzAlign);
    return thisAsT ();
  }

  @Nonnull
  public EHorzAlignment getHorzAlign ()
  {
    return m_eHorzAlign;
  }

  @Nonnull
  public IMPLTYPE setHorzAlign (@Nonnull final EHorzAlignment eHorzAlign)
  {
    m_eHorzAlign = ValueEnforcer.notNull (eHorzAlign, "HorzAlign");
    return thisAsT ();
  }

  @Override
  public String toString ()
  {
    return ToStringGenerator.getDerived (super.toString ()).append ("HorzAlign", m_eHorzAlign).toString ();
  }
}
