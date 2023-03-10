package co.edu.uniandes.dse.med4pet.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.med4pet.dto.AgendaDTO;
import co.edu.uniandes.dse.med4pet.dto.CalificacionDTO;
import co.edu.uniandes.dse.med4pet.dto.ContactoDTO;
import co.edu.uniandes.dse.med4pet.dto.RegistroMedicoDTO;
import co.edu.uniandes.dse.med4pet.dto.ServicioDTO;
import co.edu.uniandes.dse.med4pet.dto.VeterinarioDTO;
import co.edu.uniandes.dse.med4pet.dto.VeterinarioDetailDTO;
import co.edu.uniandes.dse.med4pet.entities.AgendaEntity;
import co.edu.uniandes.dse.med4pet.entities.CalificacionEntity;
import co.edu.uniandes.dse.med4pet.entities.ContactoEntity;
import co.edu.uniandes.dse.med4pet.entities.RegistroMedicoEntity;
import co.edu.uniandes.dse.med4pet.entities.ServicioEntity;
import co.edu.uniandes.dse.med4pet.entities.VeterinarioEntity;
import co.edu.uniandes.dse.med4pet.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.med4pet.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.med4pet.services.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

	@Autowired
	private VeterinarioService veterinarioService;
	
	@Autowired
	private ModelMapper modelMapper;
	
    /**
     * Busca y devuelve todos los veterinarios que existen en la aplicacion.
     *
     * @return JSONArray {@link VeterinarioDTO} - Los libros encontrados en la
     *         aplicación. Si no hay ninguno retorna una lista vacía.
     */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
    public List<VeterinarioDetailDTO> findAll() {
        List<VeterinarioEntity> vets = veterinarioService.getVeterinarios();
        return modelMapper.map(vets, new TypeToken<List<VeterinarioDetailDTO>>() {
        }.getType());
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public VeterinarioDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException{
		VeterinarioEntity veterinarioEntity = veterinarioService.getVeterinario(id);
		return modelMapper.map(veterinarioEntity, VeterinarioDetailDTO.class);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public VeterinarioDTO create(@RequestBody VeterinarioDTO veterinarioDTO) throws IllegalOperationException {
		VeterinarioEntity veterinarioEntity = veterinarioService.createVeterinario(modelMapper.map(veterinarioDTO, VeterinarioEntity.class));
		return modelMapper.map(veterinarioEntity, VeterinarioDTO.class);
	}
	
	@PostMapping(value = "/{veterinarioId}/calificaciones/{calificacionId}")
	@ResponseStatus(code = HttpStatus.OK)
	public CalificacionDTO addCalificacion(@PathVariable("veterinarioId") Long veterinarioId, 
			@PathVariable("calificacionId") Long calificacionId) throws EntityNotFoundException {
		CalificacionEntity calificacionEntity = veterinarioService.addCalificacion(veterinarioId, calificacionId);
		return modelMapper.map(calificacionEntity, CalificacionDTO.class);
	}
	
	@PostMapping(value = "/{veterinarioId}/agendas/{agendaId}")
	@ResponseStatus(code = HttpStatus.OK)
	public AgendaDTO addAgenda(@PathVariable("veterinarioId") Long veterinarioId, 
			@PathVariable("agendaId") Long agendaId) throws EntityNotFoundException {
		AgendaEntity agendaEntity = veterinarioService.addAgenda(veterinarioId, agendaId);
		return modelMapper.map(agendaEntity, AgendaDTO.class);
	}
	
	@PostMapping(value = "/{veterinarioId}/registrosMedicos/{registroMedicoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public RegistroMedicoDTO addRegistroMedico(@PathVariable("veterinarioId") Long veterinarioId,
			@PathVariable("registroMedicoId") Long registroMedicoId) throws EntityNotFoundException {
		RegistroMedicoEntity registroMedicoEntity = veterinarioService.addRegistroMedico(veterinarioId, 
				registroMedicoId);
		return modelMapper.map(registroMedicoEntity, RegistroMedicoDTO.class);
	}
	
	@PostMapping(value = "/{veterinarioId}/contactos/{contactoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ContactoDTO addContacto(@PathVariable("veterinarioId") Long veterinarioId,
			@PathVariable("contactoId") Long contactoId) throws EntityNotFoundException {
		ContactoEntity contactoEntity = veterinarioService.addContacto(veterinarioId,contactoId);
		return modelMapper.map(contactoEntity, ContactoDTO.class);
	}
	
	@PostMapping(value = "/{veterinarioId}/servicios/{servicioId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ServicioDTO addServicio(@PathVariable("veterinarioId") Long veterinarioId,
			@PathVariable("servicioId") Long servicioId) throws EntityNotFoundException {
		ServicioEntity servicioEntity = veterinarioService.addServicio(veterinarioId,servicioId);
		return modelMapper.map(servicioEntity, ServicioDTO.class);
	}
}
