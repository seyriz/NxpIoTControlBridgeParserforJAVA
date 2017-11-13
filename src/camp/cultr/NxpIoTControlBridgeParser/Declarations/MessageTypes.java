package camp.cultr.NxpIoTControlBridgeParser.Declarations;

public class MessageTypes {
   /* Common Commands */
    public static int MSG_STATUS                         =   0x8000;
    public static int MSG_LOG                            =   0x8001;

    public static int MSG_DATA_INDICATION                =   0x8002;

    public static int MSG_NODE_CLUSTER_LIST              =   0x8003;
    public static int MSG_NODE_ATTRIBUTE_LIST            =   0x8004;
    public static int MSG_NODE_COMMAND_ID_LIST           =   0x8005;

    public static int MSG_GET_VERSION                    =   0x0010;
    public static int MSG_VERSION_LIST                   =   0x8010;

    public static int MSG_SET_EXT_PANID                  =   0x0020;
    public static int MSG_SET_CHANNELMASK                =   0x0021;
    public static int MSG_SET_SECURITY                   =   0x0022;
    public static int MSG_SET_DEVICETYPE                 =   0x0023;
    public static int MSG_START_NETWORK                  =   0x0024;
    public static int MSG_START_SCAN                     =   0x0025;
    public static int MSG_NETWORK_JOINED_FORMED          =   0x8024;

    public static int MSG_RESET                          =   0x0011;
    public static int MSG_ERASE_PERSISTENT_DATA          =   0x0012;
    public static int MSG_ZLL_FACTORY_NEW                =   0x0013;
    public static int MSG_BIND                           =   0x0030;
    public static int MSG_UNBIND                         =   0x0031;

    public static int MSG_NETWORK_ADDRESS_REQUEST        =   0x0040;
    public static int MSG_IEEE_ADDRESS_REQUEST           =   0x0041;
    public static int MSG_NODE_DESCRIPTOR_REQUEST        =   0x0042;
    public static int MSG_SIMPLE_DESCRIPTOR_REQUEST      =   0x0043;
    public static int MSG_SIMPLE_DESCRIPTOR_RESPONSE     =   0x8043;
    public static int MSG_POWER_DESCRIPTOR_REQUEST       =   0x0044;
    public static int MSG_ACTIVE_ENDPOINT_REQUEST        =   0x0045;
    public static int MSG_MATCH_DESCRIPTOR_REQUEST       =   0x0046;
    public static int MSG_MATCH_DESCRIPTOR_RESPONSE      =   0x8046;
    public static int MSG_MANAGEMENT_LEAVE_REQUEST       =   0x0047;
    public static int MSG_LEAVE_CONFIRMATION             =   0x8047;
    public static int MSG_LEAVE_INDICATION               =   0x8048;
    public static int MSG_PERMIT_JOINING_REQUEST         =   0x0049;
    public static int MSG_MANAGEMENT_NETWPRK_UPDATE_REQUEST =0x004A;
    public static int MSG_SYSTEM_SERVER_DISCOVERY        =   0x004B;
    public static int MSG_COMPLEX_DESCRIPTOR_REQUEST     =   0x004C;
    public static int MSG_DEVICE_ANNOUNCE                =   0x004D;
    public static int MSG_MANAGEMENT_LQI_REQUEST         =   0x004E;
    public static int MSG_MANAGEMENT_LQI_RESPONSE        =   0x804E;

	/* Group Cluster */
    public static int MSG_ADD_GROUP                      =   0x0060;
    public static int MSG_VIEW_GROUP                     =   0x0061;
    public static int MSG_GET_GROUP_MEMBERSHIP           =   0x0062;
    public static int MSG_GET_GROUP_MEMBERSHIP_RESPONSE  =   0x8062;
    public static int MSG_REMOVE_GROUP                   =   0x0063;
    public static int MSG_REMOVE_ALL_GROUPS              =   0x0064;
    public static int MSG_ADD_GROUP_IF_IDENTIFY          =   0x0065;

	/* Identify Cluster */
    public static int MSG_IDENTIFY_SEND                  =   0x0070;
    public static int MSG_IDENTIFY_QUERY                 =   0x0071;

	/* Level Cluster */
    public static int MSG_MOVE_TO_LEVEL                  =   0x0080;
    public static int MSG_MOVE_TO_LEVEL_ONOFF            =   0x0081;
    public static int MSG_MOVE_STEP                      =   0x0082;
    public static int MSG_MOVE_STOP_MOVE                 =   0x0083;
    public static int MSG_MOVE_STOP_ONOFF                =   0x0084;

	/* On/Off Cluster */
    public static int MSG_ONOFF_NOEFFECTS                =   0x0092;
    public static int MSG_ONOFF_TIMED                    =   0x0093;
    public static int MSG_ONOFF_EFFECTS                  =   0x0094;

	/* Scenes Cluster */
    public static int MSG_VIEW_SCENE                     =   0x00A0;
    public static int MSG_ADD_SCENE                      =   0x00A1;
    public static int MSG_REMOVE_SCENE                   =   0x00A2;
    public static int MSG_REMOVE_ALL_SCENES              =   0x00A3;
    public static int MSG_STORE_SCENE                    =   0x00A4;
    public static int MSG_RECALL_SCENE                   =   0x00A5;
    public static int MSG_SCENE_MEMBERSHIP_REQUEST       =   0x00A6;

	/* Colour Cluster */
    public static int MSG_MOVE_TO_HUE                    =   0x00B0;
    public static int MSG_MOVE_HUE                       =   0x00B1;
    public static int MSG_STEP_HUE                       =   0x00B2;
    public static int MSG_MOVE_TO_SATURATION             =   0x00B3;
    public static int MSG_MOVE_SATURATION                =   0x00B4;
    public static int MSG_STEP_SATURATION                =   0x00B5;
    public static int MSG_MOVE_TO_HUE_SATURATION         =   0x00B6;
    public static int MSG_MOVE_TO_COLOUR                 =   0x00B7;
    public static int MSG_MOVE_COLOUR                    =   0x00B8;
    public static int MSG_STEP_COLOUR                    =   0x00B9;

	/* ZLL Commands */
	/* Touchlink */
    public static int MSG_INITIATE_TOUCHLINK             =   0x00D0;
    public static int MSG_TOUCHLINK_STATUS               =   0x00D1;
    public static int MSG_TOUCHLINK_FACTORY_RESET        =   0x00D2;

	/* Identify Cluster */
    public static int MSG_IDENTIFY_TRIGGER_EFFECT        =   0x00E0;

	/* Scenes Cluster */
    public static int MSG_ADD_ENHANCED_SCENE             =   0x00A7;
    public static int MSG_VIEW_ENHANCED_SCENE            =   0x00A8;
    public static int MSG_COPY_SCENE                     =   0x00A9;

	/* Colour Cluster */
    public static int MSG_ENHANCED_MOVE_TO_HUE           =   0x00BA;
    public static int MSG_ENHANCED_MOVE_HUE              =   0x00BB;
    public static int MSG_ENHANCED_STEP_HUE              =   0x00BC;
    public static int MSG_ENHANCED_MOVE_TO_HUE_SATURATION =  0x00BD;
    public static int MSG_COLOUR_LOOP_SET                =   0x00BE;
    public static int MSG_STOP_MOVE_STEP                 =   0x00BF;
    public static int MSG_MOVE_TO_COLOUR_TEMPERATURE     =   0x00C0;
    public static int MSG_MOVE_COLOUR_TEMPERATURE        =   0x00C1;
    public static int MSG_STEP_COLOUR_TEMPERATURE        =   0x00C2;

	/* ZHA Commands */
	/* Door Lock Cluster */
    public static int MSG_LOCK_UNLOCK_DOOR               =   0x00F0;
    public static int MSG_READ_ATTRIBUTE_REQUEST         =   0x0100;
    public static int MSG_READ_ATTRIBUTE_RESPONSE        =   0x8100;
    public static int MSG_SAVE_PDM_RECORD                =   0x0200;
    public static int MSG_SAVE_PDM_RECORD_RESPONSE       =   0x8200;
    public static int MSG_LOAD_PDM_RECORD_REQUEST        =   0x0201;
    public static int MSG_LOAD_PDM_RECORD_RESPONSE       =   0x8201;
    public static int MSG_DELETE_PDM_RECORD              =   0x0202;
    public static int MSG_PDM_HOST_AVAILABLE             =   0x0300;
    public static int MSG_PDM_HOST_AVAILABLE_RESPONSE    =   0x8300;
}
