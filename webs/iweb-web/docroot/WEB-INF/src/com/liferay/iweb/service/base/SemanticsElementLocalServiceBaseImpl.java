/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.iweb.service.base;

import com.liferay.iweb.model.SemanticsElement;
import com.liferay.iweb.service.CallBackLocalService;
import com.liferay.iweb.service.CallBackLocalServiceFactory;
import com.liferay.iweb.service.CrossContainerLocalService;
import com.liferay.iweb.service.CrossContainerLocalServiceFactory;
import com.liferay.iweb.service.IWebLocalService;
import com.liferay.iweb.service.IWebLocalServiceFactory;
import com.liferay.iweb.service.InterestGroupLocalService;
import com.liferay.iweb.service.InterestGroupLocalServiceFactory;
import com.liferay.iweb.service.PostEntryLocalService;
import com.liferay.iweb.service.PostEntryLocalServiceFactory;
import com.liferay.iweb.service.SemanticsElementLocalService;
import com.liferay.iweb.service.SemanticsFileLocalService;
import com.liferay.iweb.service.SemanticsFileLocalServiceFactory;
import com.liferay.iweb.service.persistence.InterestGroupPersistence;
import com.liferay.iweb.service.persistence.InterestGroupUtil;
import com.liferay.iweb.service.persistence.PostEntryPersistence;
import com.liferay.iweb.service.persistence.PostEntryUtil;
import com.liferay.iweb.service.persistence.SemanticsElementPersistence;
import com.liferay.iweb.service.persistence.SemanticsElementUtil;
import com.liferay.iweb.service.persistence.SemanticsFilePersistence;
import com.liferay.iweb.service.persistence.SemanticsFileUtil;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.bean.InitializingBean;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import java.util.List;

/**
 * <a href="SemanticsElementLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class SemanticsElementLocalServiceBaseImpl
	implements SemanticsElementLocalService, InitializingBean {
	public SemanticsElement addSemanticsElement(
		SemanticsElement semanticsElement) throws SystemException {
		semanticsElement.setNew(true);

		return semanticsElementPersistence.update(semanticsElement, false);
	}

	public void deleteSemanticsElement(String elementURI)
		throws PortalException, SystemException {
		semanticsElementPersistence.remove(elementURI);
	}

	public void deleteSemanticsElement(SemanticsElement semanticsElement)
		throws SystemException {
		semanticsElementPersistence.remove(semanticsElement);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return semanticsElementPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return semanticsElementPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	public SemanticsElement getSemanticsElement(String elementURI)
		throws PortalException, SystemException {
		return semanticsElementPersistence.findByPrimaryKey(elementURI);
	}

	public List<SemanticsElement> getSemanticsElements(int start, int end)
		throws SystemException {
		return semanticsElementPersistence.findAll(start, end);
	}

	public int getSemanticsElementsCount() throws SystemException {
		return semanticsElementPersistence.countAll();
	}

	public SemanticsElement updateSemanticsElement(
		SemanticsElement semanticsElement) throws SystemException {
		semanticsElement.setNew(false);

		return semanticsElementPersistence.update(semanticsElement, true);
	}

	public CallBackLocalService getCallBackLocalService() {
		return callBackLocalService;
	}

	public void setCallBackLocalService(
		CallBackLocalService callBackLocalService) {
		this.callBackLocalService = callBackLocalService;
	}

	public CrossContainerLocalService getCrossContainerLocalService() {
		return crossContainerLocalService;
	}

	public void setCrossContainerLocalService(
		CrossContainerLocalService crossContainerLocalService) {
		this.crossContainerLocalService = crossContainerLocalService;
	}

	public InterestGroupLocalService getInterestGroupLocalService() {
		return interestGroupLocalService;
	}

	public void setInterestGroupLocalService(
		InterestGroupLocalService interestGroupLocalService) {
		this.interestGroupLocalService = interestGroupLocalService;
	}

	public InterestGroupPersistence getInterestGroupPersistence() {
		return interestGroupPersistence;
	}

	public void setInterestGroupPersistence(
		InterestGroupPersistence interestGroupPersistence) {
		this.interestGroupPersistence = interestGroupPersistence;
	}

	public IWebLocalService getIWebLocalService() {
		return iWebLocalService;
	}

	public void setIWebLocalService(IWebLocalService iWebLocalService) {
		this.iWebLocalService = iWebLocalService;
	}

	public PostEntryLocalService getPostEntryLocalService() {
		return postEntryLocalService;
	}

	public void setPostEntryLocalService(
		PostEntryLocalService postEntryLocalService) {
		this.postEntryLocalService = postEntryLocalService;
	}

	public PostEntryPersistence getPostEntryPersistence() {
		return postEntryPersistence;
	}

	public void setPostEntryPersistence(
		PostEntryPersistence postEntryPersistence) {
		this.postEntryPersistence = postEntryPersistence;
	}

	public SemanticsElementPersistence getSemanticsElementPersistence() {
		return semanticsElementPersistence;
	}

	public void setSemanticsElementPersistence(
		SemanticsElementPersistence semanticsElementPersistence) {
		this.semanticsElementPersistence = semanticsElementPersistence;
	}

	public SemanticsFileLocalService getSemanticsFileLocalService() {
		return semanticsFileLocalService;
	}

	public void setSemanticsFileLocalService(
		SemanticsFileLocalService semanticsFileLocalService) {
		this.semanticsFileLocalService = semanticsFileLocalService;
	}

	public SemanticsFilePersistence getSemanticsFilePersistence() {
		return semanticsFilePersistence;
	}

	public void setSemanticsFilePersistence(
		SemanticsFilePersistence semanticsFilePersistence) {
		this.semanticsFilePersistence = semanticsFilePersistence;
	}

	public void afterPropertiesSet() {
		if (callBackLocalService == null) {
			callBackLocalService = CallBackLocalServiceFactory.getImpl();
		}

		if (crossContainerLocalService == null) {
			crossContainerLocalService = CrossContainerLocalServiceFactory.getImpl();
		}

		if (interestGroupLocalService == null) {
			interestGroupLocalService = InterestGroupLocalServiceFactory.getImpl();
		}

		if (interestGroupPersistence == null) {
			interestGroupPersistence = InterestGroupUtil.getPersistence();
		}

		if (iWebLocalService == null) {
			iWebLocalService = IWebLocalServiceFactory.getImpl();
		}

		if (postEntryLocalService == null) {
			postEntryLocalService = PostEntryLocalServiceFactory.getImpl();
		}

		if (postEntryPersistence == null) {
			postEntryPersistence = PostEntryUtil.getPersistence();
		}

		if (semanticsElementPersistence == null) {
			semanticsElementPersistence = SemanticsElementUtil.getPersistence();
		}

		if (semanticsFileLocalService == null) {
			semanticsFileLocalService = SemanticsFileLocalServiceFactory.getImpl();
		}

		if (semanticsFilePersistence == null) {
			semanticsFilePersistence = SemanticsFileUtil.getPersistence();
		}
	}

	protected CallBackLocalService callBackLocalService;
	protected CrossContainerLocalService crossContainerLocalService;
	protected InterestGroupLocalService interestGroupLocalService;
	protected InterestGroupPersistence interestGroupPersistence;
	protected IWebLocalService iWebLocalService;
	protected PostEntryLocalService postEntryLocalService;
	protected PostEntryPersistence postEntryPersistence;
	protected SemanticsElementPersistence semanticsElementPersistence;
	protected SemanticsFileLocalService semanticsFileLocalService;
	protected SemanticsFilePersistence semanticsFilePersistence;
}