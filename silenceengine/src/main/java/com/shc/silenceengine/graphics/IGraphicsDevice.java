/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 Sri Harsha Chilakapati
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.shc.silenceengine.graphics;

import com.shc.silenceengine.io.DirectBuffer;
import com.shc.silenceengine.io.DirectFloatBuffer;

/**
 * Describes a graphics device which is used to provide OpenGL functions on a target platform.
 *
 * @author Sri Harsha Chilakapati
 */
public interface IGraphicsDevice
{
    int glGenBuffers();

    boolean glIsBuffer(int buffer);

    void glBufferData(int value, DirectBuffer data, int usage);

    void glBufferSubData(int target, int offset, int size, DirectBuffer data);

    void glBindBuffer(int target, int buffer);

    void glBufferData(int target, int capacity, int usage);

    void glBufferSubData(int target, int offset, DirectBuffer data);

    void glDeleteBuffers(int... buffer);

    int glGenFramebuffers();

    boolean glIsFramebuffer(int framebuffer);

    void glFramebufferTexture2D(int target, int attachment, int textureTarget, int texture, int level);

    void glBindFramebuffer(int target, int framebuffer);

    void glViewport(int x, int y, int width, int height);

    default void glClear(int flags)
    {
        Data.renderCallsThisFrame = 0;
    }

    int glCheckFramebufferStatus(int target);

    void glDeleteFramebuffers(int... framebuffer);

    default void glDrawArrays(int primitive, int offset, int vertexCount)
    {
        Data.renderCallsThisFrame++;
        Data.totalRenderCalls++;
    }

    default void glDrawElements(int primitive, int vertexCount, int type, int offset)
    {
        Data.renderCallsThisFrame++;
        Data.totalRenderCalls++;
    }

    void glEnable(int capability);

    void glBlendFunc(int src, int dst);

    void glDisable(int capability);

    void glClearColor(float r, float g, float b, float a);

    void glBindVertexArray(int vaoID);

    void glDepthMask(boolean value);

    void glDepthFunc(int func);

    void glCullFace(int mode);

    int glGetError();

    int glCreateProgram();

    void glAttachShader(int program, int shader);

    void glLinkProgram(int program);

    int glGetProgrami(int program, int param);

    String glGetProgramInfoLog(int program);

    int glGetAttribLocation(int program, String name);

    void glUseProgram(int program);

    int glGetUniformLocation(int program, String name);

    void glUniform1i(int location, int value);

    void glUniform2i(int location, int v1, int v2);

    void glUniform3i(int location, int v1, int v2, int v3);

    void glUniform4i(int location, int v1, int v2, int v3, int v4);

    void glUniform1f(int location, float value);

    void glUniform2f(int location, float v1, float v2);

    void glUniform3f(int location, float v1, float v2, float v3);

    void glUniform4f(int location, float v1, float v2, float v3, float v4);

    void glUniformMatrix3fv(int location, boolean transpose, DirectFloatBuffer matrix);

    void glUniformMatrix4fv(int location, boolean transpose, DirectFloatBuffer matrix);

    void glDeleteProgram(int... id);

    int glCreateShader(int type);

    void glShaderSource(int shader, String... source);

    void glCompileShader(int shader);

    int glGetShaderi(int shader, int param);

    String glGetShaderInfoLog(int shader);

    void glDeleteShader(int... shader);

    int glGenTextures();

    void glActiveTexture(int unit);

    void glBindTexture(int target, int texture);

    void glTexParameteri(int target, int param, int value);

    void glTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int format,
                      int type, DirectBuffer pixels);

    void glGenerateMipmap(int target);

    void glDeleteTextures(int... texture);

    int glGenVertexArrays();

    boolean glIsVertexArray(int vertexArray);

    void glEnableVertexAttribArray(int index);

    void glDisableVertexAttribArray(int index);

    void glVertexAttribPointer(int index, int count, int type, boolean normalized, int stride, long offset);

    void glDeleteVertexArrays(int... vertexArray);

    boolean glIsProgram(int id);

    final class Constants
    {
        public static final int GL_NO_ERROR                                     = 0x0000;
        public static final int GL_ACTIVE_ATTRIBUTES                            = 0x8B89;
        public static final int GL_ACTIVE_TEXTURE                               = 0x84E0;
        public static final int GL_ACTIVE_UNIFORMS                              = 0x8B86;
        public static final int GL_ALIASED_LINE_WIDTH_RANGE                     = 0x846E;
        public static final int GL_ALIASED_POINT_SIZE_RANGE                     = 0x846D;
        public static final int GL_ALPHA                                        = 0x1906;
        public static final int GL_ALPHA_BITS                                   = 0x0D55;
        public static final int GL_ALWAYS                                       = 0x0207;
        public static final int GL_ARRAY_BUFFER                                 = 0x8892;
        public static final int GL_ARRAY_BUFFER_BINDING                         = 0x8894;
        public static final int GL_ATTACHED_SHADERS                             = 0x8B85;
        public static final int GL_BACK                                         = 0x0405;
        public static final int GL_BLEND                                        = 0x0BE2;
        public static final int GL_BLEND_COLOR                                  = 0x8005;
        public static final int GL_BLEND_DST_ALPHA                              = 0x80CA;
        public static final int GL_BLEND_DST_RGB                                = 0x80C8;
        public static final int GL_BLEND_EQUATION                               = 0x8009;
        public static final int GL_BLEND_EQUATION_ALPHA                         = 0x883D;
        public static final int GL_BLEND_EQUATION_RGB                           = 0x8009;
        public static final int GL_BLEND_SRC_ALPHA                              = 0x80CB;
        public static final int GL_BLEND_SRC_RGB                                = 0x80C9;
        public static final int GL_BLUE_BITS                                    = 0x0D54;
        public static final int GL_BOOL                                         = 0x8B56;
        public static final int GL_BOOL_VEC2                                    = 0x8B57;
        public static final int GL_BOOL_VEC3                                    = 0x8B58;
        public static final int GL_BOOL_VEC4                                    = 0x8B59;
        public static final int GL_BROWSER_DEFAULT_WEBGL                        = 0x9244;
        public static final int GL_BUFFER_SIZE                                  = 0x8764;
        public static final int GL_BUFFER_USAGE                                 = 0x8765;
        public static final int GL_BYTE                                         = 0x1400;
        public static final int GL_CCW                                          = 0x0901;
        public static final int GL_CLAMP_TO_EDGE                                = 0x812F;
        public static final int GL_COLOR_ATTACHMENT0                            = 0x8CE0;
        public static final int GL_COLOR_BUFFER_BIT                             = 0x4000;
        public static final int GL_COLOR_CLEAR_VALUE                            = 0x0C22;
        public static final int GL_COLOR_WRITEMASK                              = 0x0C23;
        public static final int GL_COMPILE_STATUS                               = 0x8B81;
        public static final int GL_COMPRESSED_TEXTURE_FORMATS                   = 0x86A3;
        public static final int GL_CONSTANT_ALPHA                               = 0x8003;
        public static final int GL_CONSTANT_COLOR                               = 0x8001;
        public static final int GL_CONTEXT_LOST_WEBGL                           = 0x9242;
        public static final int GL_CULL_FACE                                    = 0x0B44;
        public static final int GL_CULL_FACE_MODE                               = 0x0B45;
        public static final int GL_CURRENT_PROGRAM                              = 0x8B8D;
        public static final int GL_CURRENT_VERTEX_ATTRIB                        = 0x8626;
        public static final int GL_CW                                           = 0x0900;
        public static final int GL_DECR                                         = 0x1E03;
        public static final int GL_DECR_WRAP                                    = 0x8508;
        public static final int GL_DELETE_STATUS                                = 0x8B80;
        public static final int GL_DEPTH_ATTACHMENT                             = 0x8D00;
        public static final int GL_DEPTH_BITS                                   = 0x0D56;
        public static final int GL_DEPTH_BUFFER_BIT                             = 0x0100;
        public static final int GL_DEPTH_CLEAR_VALUE                            = 0x0B73;
        public static final int GL_DEPTH_COMPONENT                              = 0x1902;
        public static final int GL_DEPTH_COMPONENT16                            = 0x81A5;
        public static final int GL_DEPTH_FUNC                                   = 0x0B74;
        public static final int GL_DEPTH_RANGE                                  = 0x0B70;
        public static final int GL_DEPTH_STENCIL                                = 0x84F9;
        public static final int GL_DEPTH_STENCIL_ATTACHMENT                     = 0x821A;
        public static final int GL_DEPTH_TEST                                   = 0x0B71;
        public static final int GL_DEPTH_WRITEMASK                              = 0x0B72;
        public static final int GL_DITHER                                       = 0x0BD0;
        public static final int GL_DONT_CARE                                    = 0x1100;
        public static final int GL_DST_ALPHA                                    = 0x0304;
        public static final int GL_DST_COLOR                                    = 0x0306;
        public static final int GL_DYNAMIC_DRAW                                 = 0x88E8;
        public static final int GL_ELEMENT_ARRAY_BUFFER                         = 0x8893;
        public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING                 = 0x8895;
        public static final int GL_EQUAL                                        = 0x0202;
        public static final int GL_FALSE                                        = 0x0000;
        public static final int GL_FASTEST                                      = 0x1101;
        public static final int GL_FLOAT                                        = 0x1406;
        public static final int GL_FLOAT_MAT2                                   = 0x8B5A;
        public static final int GL_FLOAT_MAT3                                   = 0x8B5B;
        public static final int GL_FLOAT_MAT4                                   = 0x8B5C;
        public static final int GL_FLOAT_VEC2                                   = 0x8B50;
        public static final int GL_FLOAT_VEC3                                   = 0x8B51;
        public static final int GL_FLOAT_VEC4                                   = 0x8B52;
        public static final int GL_FRAGMENT_SHADER                              = 0x8B30;
        public static final int GL_FRAMEBUFFER                                  = 0x8D40;
        public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME           = 0x8CD1;
        public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE           = 0x8CD0;
        public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
        public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL         = 0x8CD2;
        public static final int GL_FRAMEBUFFER_BINDING                          = 0x8CA6;
        public static final int GL_FRAMEBUFFER_COMPLETE                         = 0x8CD5;
        public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT            = 0x8CD6;
        public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS            = 0x8CD9;
        public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT    = 0x8CD7;
        public static final int GL_FRAMEBUFFER_UNSUPPORTED                      = 0x8CDD;
        public static final int GL_FRONT                                        = 0x0404;
        public static final int GL_FRONT_AND_BACK                               = 0x0408;
        public static final int GL_FRONT_FACE                                   = 0x0B46;
        public static final int GL_FUNC_ADD                                     = 0x8006;
        public static final int GL_FUNC_REVERSE_SUBTRACT                        = 0x800B;
        public static final int GL_FUNC_SUBTRACT                                = 0x800A;
        public static final int GL_GENERATE_MIPMAP_HINT                         = 0x8192;
        public static final int GL_GEQUAL                                       = 0x0206;
        public static final int GL_GREATER                                      = 0x0204;
        public static final int GL_GREEN_BITS                                   = 0x0D53;
        public static final int GL_HIGH_FLOAT                                   = 0x8DF2;
        public static final int GL_HIGH_INT                                     = 0x8DF5;
        public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT             = 0x8B9B;
        public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE               = 0x8B9A;
        public static final int GL_INCR                                         = 0x1E02;
        public static final int GL_INCR_WRAP                                    = 0x8507;
        public static final int GL_INT                                          = 0x1404;
        public static final int GL_INT_VEC2                                     = 0x8B53;
        public static final int GL_INT_VEC3                                     = 0x8B54;
        public static final int GL_INT_VEC4                                     = 0x8B55;
        public static final int GL_INVALID_ENUM                                 = 0x0500;
        public static final int GL_INVALID_FRAMEBUFFER_OPERATION                = 0x0506;
        public static final int GL_INVALID_OPERATION                            = 0x0502;
        public static final int GL_INVALID_VALUE                                = 0x0501;
        public static final int GL_INVERT                                       = 0x150A;
        public static final int GL_KEEP                                         = 0x1E00;
        public static final int GL_LEQUAL                                       = 0x0203;
        public static final int GL_LESS                                         = 0x0201;
        public static final int GL_LINEAR                                       = 0x2601;
        public static final int GL_LINEAR_MIPMAP_LINEAR                         = 0x2703;
        public static final int GL_LINEAR_MIPMAP_NEAREST                        = 0x2701;
        public static final int GL_LINES                                        = 0x0001;
        public static final int GL_LINE_LOOP                                    = 0x0002;
        public static final int GL_LINE_STRIP                                   = 0x0003;
        public static final int GL_LINE_WIDTH                                   = 0x0B21;
        public static final int GL_LINK_STATUS                                  = 0x8B82;
        public static final int GL_LOW_FLOAT                                    = 0x8DF0;
        public static final int GL_LOW_INT                                      = 0x8DF3;
        public static final int GL_LUMINANCE                                    = 0x1909;
        public static final int GL_LUMINANCE_ALPHA                              = 0x190A;
        public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS             = 0x8B4D;
        public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE                    = 0x851C;
        public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS                 = 0x8DFD;
        public static final int GL_MAX_RENDERBUFFER_SIZE                        = 0x84E8;
        public static final int GL_MAX_TEXTURE_IMAGE_UNITS                      = 0x8872;
        public static final int GL_MAX_TEXTURE_SIZE                             = 0x8872;
        public static final int GL_MAX_VARYING_VECTORS                          = 0x8DFC;
        public static final int GL_MAX_VERTEX_ATTRIBS                           = 0x8869;
        public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS               = 0x8B4C;
        public static final int GL_MAX_VERTEX_UNIFORM_VECTORS                   = 0x8DFB;
        public static final int GL_MAX_VIEWPORT_DIMS                            = 0x0D3A;
        public static final int GL_MEDIUM_FLOAT                                 = 0x8DF1;
        public static final int GL_MEDIUM_INT                                   = 0x8DF4;
        public static final int GL_MIRRORED_REPEAT                              = 0x8370;
        public static final int GL_NEAREST                                      = 0x2600;
        public static final int GL_NEAREST_MIPMAP_LINEAR                        = 0x2702;
        public static final int GL_NEAREST_MIPMAP_NEAREST                       = 0x2700;
        public static final int GL_NEVER                                        = 0x0200;
        public static final int GL_NICEST                                       = 0x1102;
        public static final int GL_NONE                                         = 0x0000;
        public static final int GL_NOTEQUAL                                     = 0x0205;
        public static final int GL_NOERROR                                      = 0x0000;
        public static final int GL_ONE                                          = 0x0001;
        public static final int GL_ONE_MINUS_CONSTANT_ALPHA                     = 0x8004;
        public static final int GL_ONE_MINUS_CONSTANT_COLOR                     = 0x8002;
        public static final int GL_ONE_MINUS_DST_ALPHA                          = 0x0305;
        public static final int GL_ONE_MINUS_DST_COLOR                          = 0x0307;
        public static final int GL_ONE_MINUS_SRC_ALPHA                          = 0x0303;
        public static final int GL_ONE_MINUS_SRC_COLOR                          = 0x0301;
        public static final int GL_OUT_OF_MEMORY                                = 0x0505;
        public static final int GL_PACK_ALIGNMENT                               = 0x0D05;
        public static final int GL_POINTS                                       = 0x0000;
        public static final int GL_POLYGON_OFFSET_FACTOR                        = 0x8038;
        public static final int GL_POLYGON_OFFSET_FILL                          = 0x8037;
        public static final int GL_POLYGON_OFFSET_UNITS                         = 0x2A00;
        public static final int GL_RED_BITS                                     = 0x0D52;
        public static final int GL_RENDERBUFFER                                 = 0x8D41;
        public static final int GL_RENDERBUFFER_ALPHA_SIZE                      = 0x8D53;
        public static final int GL_RENDERBUFFER_BINDING                         = 0x8CA7;
        public static final int GL_RENDERBUFFER_BLUE_SIZE                       = 0x8D52;
        public static final int GL_RENDERBUFFER_DEPTH_SIZE                      = 0x8D54;
        public static final int GL_RENDERBUFFER_GREEN_SIZE                      = 0x8D51;
        public static final int GL_RENDERBUFFER_HEIGHT                          = 0x8D43;
        public static final int GL_RENDERBUFFER_INTERNAL_FORMAT                 = 0x8D44;
        public static final int GL_RENDERBUFFER_RED_SIZE                        = 0x8D50;
        public static final int GL_RENDERBUFFER_STENCIL_SIZE                    = 0x8D55;
        public static final int GL_RENDERBUFFER_WIDTH                           = 0x8D42;
        public static final int GL_RENDERER                                     = 0x1F01;
        public static final int GL_REPEAT                                       = 0x2901;
        public static final int GL_REPLACE                                      = 0x1E01;
        public static final int GL_RGB                                          = 0x1907;
        public static final int GL_RGB565                                       = 0x8D62;
        public static final int GL_RGB5_A1                                      = 0x8057;
        public static final int GL_RGBA                                         = 0x1908;
        public static final int GL_RGBA4                                        = 0x8056;
        public static final int GL_SAMPLER_2D                                   = 0x8B5E;
        public static final int GL_SAMPLER_CUBE                                 = 0x8B60;
        public static final int GL_SAMPLES                                      = 0x80A9;
        public static final int GL_SAMPLE_ALPHA_TO_COVERAGE                     = 0x809E;
        public static final int GL_SAMPLE_BUFFERS                               = 0x80A8;
        public static final int GL_SAMPLE_COVERAGE                              = 0x80A0;
        public static final int GL_SAMPLE_COVERAGE_INVERT                       = 0x80AB;
        public static final int GL_SAMPLE_COVERAGE_VALUE                        = 0x80AA;
        public static final int GL_SCISSOR_BOX                                  = 0x0C10;
        public static final int GL_SCISSOR_TEST                                 = 0x0C11;
        public static final int GL_SHADER_TYPE                                  = 0x8B4F;
        public static final int GL_SHADING_LANGUAGE_VERSION                     = 0x8B8C;
        public static final int GL_SHORT                                        = 0x1402;
        public static final int GL_SRC_ALPHA                                    = 0x0302;
        public static final int GL_SRC_ALPHA_SATURATE                           = 0x0308;
        public static final int GL_SRC_COLOR                                    = 0x0300;
        public static final int GL_STATIC_DRAW                                  = 0x88E4;
        public static final int GL_STENCIL_ATTACHMENT                           = 0x8D20;
        public static final int GL_STENCIL_BACK_FAIL                            = 0x8801;
        public static final int GL_STENCIL_BACK_FUNC                            = 0x8800;
        public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL                 = 0x8802;
        public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS                 = 0x8803;
        public static final int GL_STENCIL_BACK_REF                             = 0x8CA3;
        public static final int GL_STENCIL_BACK_VALUE_MASK                      = 0x8CA4;
        public static final int GL_STENCIL_BACK_WRITEMASK                       = 0x8CA5;
        public static final int GL_STENCIL_BITS                                 = 0x0D57;
        public static final int GL_STENCIL_BUFFER_BIT                           = 0x0400;
        public static final int GL_STENCIL_CLEAR_VALUE                          = 0x0B91;
        public static final int GL_STENCIL_FAIL                                 = 0x0B94;
        public static final int GL_STENCIL_FUNC                                 = 0x0B92;
        public static final int GL_STENCIL_INDEX                                = 0x1901;
        public static final int GL_STENCIL_INDEX8                               = 0x8D48;
        public static final int GL_STENCIL_PASS_DEPTH_FAIL                      = 0x0B95;
        public static final int GL_STENCIL_PASS_DEPTH_PASS                      = 0x0B96;
        public static final int GL_STENCIL_REF                                  = 0x0B97;
        public static final int GL_STENCIL_TEST                                 = 0x0B90;
        public static final int GL_STENCIL_VALUE_MASK                           = 0x0B93;
        public static final int GL_STENCIL_WRITEMASK                            = 0x0B98;
        public static final int GL_STREAM_DRAW                                  = 0x88E0;
        public static final int GL_SUBPIXEL_BITS                                = 0x0D50;
        public static final int GL_TEXTURE                                      = 0x1702;
        public static final int GL_TEXTURE0                                     = 0x84C0;
        public static final int GL_TEXTURE1                                     = 0x84C1;
        public static final int GL_TEXTURE2                                     = 0x84C2;
        public static final int GL_TEXTURE3                                     = 0x84C3;
        public static final int GL_TEXTURE4                                     = 0x84C4;
        public static final int GL_TEXTURE5                                     = 0x84C5;
        public static final int GL_TEXTURE6                                     = 0x84C6;
        public static final int GL_TEXTURE7                                     = 0x84C7;
        public static final int GL_TEXTURE8                                     = 0x84C8;
        public static final int GL_TEXTURE9                                     = 0x84C9;
        public static final int GL_TEXTURE10                                    = 0x84CA;
        public static final int GL_TEXTURE11                                    = 0x84CB;
        public static final int GL_TEXTURE12                                    = 0x84CC;
        public static final int GL_TEXTURE13                                    = 0x84CD;
        public static final int GL_TEXTURE14                                    = 0x84CE;
        public static final int GL_TEXTURE15                                    = 0x84CF;
        public static final int GL_TEXTURE16                                    = 0x84D0;
        public static final int GL_TEXTURE17                                    = 0x84D1;
        public static final int GL_TEXTURE18                                    = 0x84D2;
        public static final int GL_TEXTURE19                                    = 0x84D3;
        public static final int GL_TEXTURE20                                    = 0x84D4;
        public static final int GL_TEXTURE21                                    = 0x84D5;
        public static final int GL_TEXTURE22                                    = 0x84D6;
        public static final int GL_TEXTURE23                                    = 0x84D7;
        public static final int GL_TEXTURE24                                    = 0x84D8;
        public static final int GL_TEXTURE25                                    = 0x84D9;
        public static final int GL_TEXTURE26                                    = 0x84DA;
        public static final int GL_TEXTURE27                                    = 0x84DB;
        public static final int GL_TEXTURE28                                    = 0x84DC;
        public static final int GL_TEXTURE29                                    = 0x84DD;
        public static final int GL_TEXTURE30                                    = 0x84DE;
        public static final int GL_TEXTURE31                                    = 0x84DF;
        public static final int GL_TEXTURE_2D                                   = 0x0DE1;
        public static final int GL_TEXTURE_BINDING_2D                           = 0x8069;
        public static final int GL_TEXTURE_BINDING_CUBE_MAP                     = 0x8514;
        public static final int GL_TEXTURE_CUBE_MAP                             = 0x8513;
        public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X                  = 0x8516;
        public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y                  = 0x8518;
        public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z                  = 0x851A;
        public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X                  = 0x8515;
        public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y                  = 0x8517;
        public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z                  = 0x8519;
        public static final int GL_TEXTURE_MAG_FILTER                           = 0x2800;
        public static final int GL_TEXTURE_MIN_FILTER                           = 0x2801;
        public static final int GL_TEXTURE_WRAP_S                               = 0x2802;
        public static final int GL_TEXTURE_WRAP_T                               = 0x2803;
        public static final int GL_TRIANGLES                                    = 0x0004;
        public static final int GL_TRIANGLE_FAN                                 = 0x0006;
        public static final int GL_TRIANGLE_STRIP                               = 0x0005;
        public static final int GL_TRUE                                         = 0x0001;
        public static final int GL_UNPACK_ALIGNMENT                             = 0x0CF5;
        public static final int GL_UNPACK_COLORSPACE_CONVERSION_WEBGL           = 0x9243;
        public static final int GL_UNPACK_FLIP_Y_WEBGL                          = 0x9240;
        public static final int GL_UNPACK_PREMULTIPLY_ALPHA_WEBGL               = 0x9241;
        public static final int GL_UNSIGNED_BYTE                                = 0x1401;
        public static final int GL_UNSIGNED_INT                                 = 0x1405;
        public static final int GL_UNSIGNED_SHORT                               = 0x1403;
        public static final int GL_UNSIGNED_SHORT_4_4_4_4                       = 0x8033;
        public static final int GL_UNSIGNED_SHORT_5_5_5_1                       = 0x8034;
        public static final int GL_UNSIGNED_SHORT_5_6_5                         = 0x8363;
        public static final int GL_VALIDATE_STATUS                              = 0x8B83;
        public static final int GL_VENDOR                                       = 0x1F00;
        public static final int GL_VERSION                                      = 0x1F02;
        public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING           = 0x889F;
        public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED                  = 0x8622;
        public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED               = 0x886A;
        public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER                  = 0x8645;
        public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE                     = 0x8623;
        public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE                   = 0x8624;
        public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE                     = 0x8625;
        public static final int GL_VERTEX_SHADER                                = 0x8B31;
        public static final int GL_VIEWPORT                                     = 0x0BA2;
        public static final int GL_ZERO                                         = 0x0000;

        private Constants()
        {
        }
    }

    final class Data
    {
        public static int totalRenderCalls     = 0;
        public static int renderCallsThisFrame = 0;
    }
}
