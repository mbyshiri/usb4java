/*
 * Copyright (C) 2011 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.usb4java.topology;

import java.util.ArrayList;
import java.util.List;

import javax.usb.UsbConfiguration;
import javax.usb.UsbConfigurationDescriptor;
import javax.usb.UsbConst;
import javax.usb.UsbDevice;
import javax.usb.UsbInterface;

import de.ailis.usb4java.descriptors.SimpleUsbConfigurationDescriptor;


/**
 * Virtual USB configuration used by the virtual USB root hub.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class VirtualRootHubConfiguration implements UsbConfiguration
{
    /** The virtual interfaces. */
    private final List<UsbInterface> interfaces =
        new ArrayList<UsbInterface>();

    /** The device this configuration belongs to. */
    private final UsbDevice device;

    /** The USB configuration descriptor. */
    private final UsbConfigurationDescriptor descriptor =
        new SimpleUsbConfigurationDescriptor(
             UsbConst.DESCRIPTOR_MIN_LENGTH_CONFIGURATION,
             UsbConst.DESCRIPTOR_TYPE_CONFIGURATION,
             (byte) (UsbConst.DESCRIPTOR_MIN_LENGTH_CONFIGURATION
                + UsbConst.DESCRIPTOR_MIN_LENGTH_INTERFACE),
             (byte) 1,
             (byte) 1,
             (byte) 0,
             (byte) 0x80,
             (byte) 0);


    /**
     * Constructor.
     *
     * @param device
     *            The device this configuration belongs to.
     */

    VirtualRootHubConfiguration(final UsbDevice device)
    {
        this.device = device;
        this.interfaces.add(new VirtualRootHubInterface(this));
    }


    /**
     * @see UsbConfiguration#isActive()
     */

    @Override
    public boolean isActive()
    {
        return true;
    }


    /**
     * @see UsbConfiguration#getUsbInterfaces()
     */

    @Override
    public List<UsbInterface> getUsbInterfaces()
    {
        return this.interfaces;
    }


    /**
     * @see UsbConfiguration#getUsbInterface(byte)
     */

    @Override
    public UsbInterface getUsbInterface(final byte number)
    {
        if (number != 0) return null;
        return this.interfaces.get(0);
    }


    /**
     * @see UsbConfiguration#containsUsbInterface(byte)
     */

    @Override
    public boolean containsUsbInterface(final byte number)
    {
        return number == 0;
    }


    /**
     * @see javax.usb.UsbConfiguration#getUsbDevice()
     */

    @Override
    public UsbDevice getUsbDevice()
    {
        return this.device;
    }


    /**
     * @see javax.usb.UsbConfiguration#getUsbConfigurationDescriptor()
     */

    @Override
    public UsbConfigurationDescriptor getUsbConfigurationDescriptor()
    {
        return this.descriptor;
    }

    /**
     * @see javax.usb.UsbConfiguration#getConfigurationString()
     */

    @Override
    public String getConfigurationString()
    {
        return null;
    }
}