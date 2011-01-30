/*
 * Copyright (C) 2011 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.usb4java.jsr80;

import javax.usb.UsbConfigurationDescriptor;
import javax.usb.UsbConst;
import javax.usb.UsbDescriptor;


/**
 * The virtual USB configuration descriptor used by the virtual USB root hub.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

final class VirtualUsbConfigurationDescriptor implements
        UsbConfigurationDescriptor
{
    /**
     * @see UsbDescriptor#bLength()
     */

    @Override
    public byte bLength()
    {
        return UsbConst.DESCRIPTOR_MIN_LENGTH_CONFIGURATION;
    }


    /**
     * @see UsbDescriptor#bDescriptorType()
     */

    @Override
    public byte bDescriptorType()
    {
        return UsbConst.DESCRIPTOR_TYPE_CONFIGURATION;
    }


    /**
     * @see UsbConfigurationDescriptor#wTotalLength()
     */

    @Override
    public short wTotalLength()
    {
        return UsbConst.DESCRIPTOR_MIN_LENGTH_CONFIGURATION + UsbConst.DESCRIPTOR_MIN_LENGTH_INTERFACE;
    }


    /**
     * @see UsbConfigurationDescriptor#bNumInterfaces()
     */

    @Override
    public byte bNumInterfaces()
    {
        return 1;
    }


    /**
     * @see UsbConfigurationDescriptor#bConfigurationValue()
     */

    @Override
    public byte bConfigurationValue()
    {
        return 1;
    }


    /**
     * @see UsbConfigurationDescriptor#iConfiguration()
     */

    @Override
    public byte iConfiguration()
    {
        return 0;
    }


    /**
     * @see UsbConfigurationDescriptor#bmAttributes()
     */

    @Override
    public byte bmAttributes()
    {
        return (byte) 0x80;
    }


    /**
     * @see UsbConfigurationDescriptor#bMaxPower()
     */

    @Override
    public byte bMaxPower()
    {
        return 0;
    }
}
