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
package com.helger.pdflayout.element.text;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.OverrideOnDemand;
import com.helger.commons.string.StringHelper;
import com.helger.pdflayout.render.PagePreRenderContext;
import com.helger.pdflayout.render.PageRenderContext;
import com.helger.pdflayout.spec.FontSpec;

/**
 * Render text but before that replace all placeholders defined in the
 * {@link PageRenderContext}.
 *
 * @author Philip Helger
 */
public class PLTextWithPlaceholders extends AbstractPLText <PLTextWithPlaceholders>
{
  public PLTextWithPlaceholders (@Nullable final String sText, @Nonnull final FontSpec aFontSpec)
  {
    super (sText, aFontSpec);
  }

  @Override
  public void beforeRender (@Nonnull final PagePreRenderContext aCtx) throws IOException
  {
    final String sOrigText = getText ();
    final String sRealText = StringHelper.replaceMultiple (getText (), aCtx.getAllPlaceholders ());
    if (!sOrigText.equals (sRealText))
    {
      setNewTextAfterPrepare (sRealText, getPrepareAvailableSize ().getWidth ());
    }
  }

  @Override
  @OverrideOnDemand
  protected String getTextToDraw (@Nonnull final String sText, @Nonnull final PageRenderContext aCtx)
  {
    return sText;
  }
}
